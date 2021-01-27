package org.example.testcontainer;

import org.example.config.CalculatorServiceProperties;
import org.example.testcontainer.network.INetworkService;
import org.example.testcontainer.util.ContainerUrlUtil;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Service
public final class CalculatorContainerService implements IContainerService {

    private final Integer containerPort;

    private final GenericContainer<?> calculatorContainer;

    public CalculatorContainerService(INetworkService networkService,
                                      CalculatorServiceProperties calculatorServiceProperties,
                                      AdditionContainerService additionContainerService,
                                      SubtractionContainerService subtractionContainerService) {

        DockerImageName calculatorServiceImage = DockerImageName
                .parse(calculatorServiceProperties.getImageName())
                .asCompatibleSubstituteFor("calculator-service");

        this.calculatorContainer = new GenericContainer<>(calculatorServiceImage)
                .withExposedPorts(calculatorServiceProperties.getPort())
                .withNetwork(networkService.getNetwork())
                .withEnv(calculatorServiceProperties.getAdditionServiceUrlEnvName(),
                        ContainerUrlUtil.containerPortReplacer(
                                calculatorServiceProperties.getAdditionServiceUrlEnvValue(),
                                additionContainerService.getContainerPort()
                        ))
                .withEnv(calculatorServiceProperties.getSubtractionServiceUrlEnvName(),
                        ContainerUrlUtil.containerPortReplacer(
                                calculatorServiceProperties.getSubtractionServiceUrlEnvValue(),
                                subtractionContainerService.getContainerPort()
                        ))
                .withEnv("SERVER_PORT", calculatorServiceProperties.getPort().toString())
                .dependsOn(additionContainerService.getAdditionContainer(), subtractionContainerService.getSubtractionContainer());

        this.calculatorContainer.start();

        this.containerPort = this.calculatorContainer.getMappedPort(calculatorServiceProperties.getPort());
    }

    public Integer getContainerPort() {
        return this.containerPort;
    }

    public void closeContainer() {
        this.calculatorContainer.close();
    }
}
