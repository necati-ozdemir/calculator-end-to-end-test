package org.example.testcontainer;

import org.example.config.CalculatorUIProperties;
import org.example.testcontainer.network.INetworkService;
import org.example.testcontainer.util.ContainerUrlUtil;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

@Service
public final class CalculatorUIContainerService implements IContainerService {

    private final String containerUrl;
    private final Integer containerPort;

    private final GenericContainer<?> calculatorUIContainer;

    public CalculatorUIContainerService(INetworkService networkService,
                                        CalculatorUIProperties calculatorUIProperties,
                                        CalculatorContainerService calculatorContainerService) {

        DockerImageName calculatorUIImage = DockerImageName
                .parse(calculatorUIProperties.getImageName())
                .asCompatibleSubstituteFor("calculator-ui");

        this.calculatorUIContainer = new GenericContainer<>(calculatorUIImage)
                .withExposedPorts(calculatorUIProperties.getPort())
                .withNetwork(networkService.getNetwork())
                .waitingFor(Wait.forHttp("/"))
                .withEnv(calculatorUIProperties.getCalculatorServiceAdditionUrlEnvName(),
                        ContainerUrlUtil.containerPortReplacer(
                                calculatorUIProperties.getCalculatorServiceAdditionUrlEnvValue(),
                                calculatorContainerService.getContainerPort()
                        ))
                .withEnv(calculatorUIProperties.getCalculatorServiceSubtractionUrlEnvName(),
                        ContainerUrlUtil.containerPortReplacer(
                                calculatorUIProperties.getCalculatorServiceSubtractionUrlEnvValue(),
                                calculatorContainerService.getContainerPort()
                        ))
                .withEnv("PORT", calculatorUIProperties.getPort().toString());

        this.calculatorUIContainer.start();

        this.containerPort = this.calculatorUIContainer.getMappedPort(calculatorUIProperties.getPort());
        this.containerUrl = ContainerUrlUtil.combineHttpUrlParts(
                calculatorUIProperties.getIp(),
                this.containerPort
        );
    }

    public String getUrl() {
        return this.containerUrl;
    }

    public Integer getContainerPort() {
        return this.containerPort;
    }

    public void closeContainer() {
        this.calculatorUIContainer.close();
    }
}
