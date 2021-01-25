package org.example.testcontainer;

import org.example.config.CalculatorServiceProperties;
import org.example.testcontainer.util.ContainerUrlUtil;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Service
public final class CalculatorContainerService implements IContainerService {

    private static final DockerImageName CALCULATOR_SERVICE = DockerImageName
            .parse("mbarkin26/calculator-service:latest")
            .asCompatibleSubstituteFor("calculator-service");

    private final Integer containerPort;

    private final GenericContainer<?> calculatorContainer;

    public CalculatorContainerService(NetworkService networkService,
                                      CalculatorServiceProperties calculatorServiceProperties,
                                      AdditionContainerService additionContainerService,
                                      SubtractionContainerService subtractionContainerService) {

        this.calculatorContainer = new GenericContainer<>(CALCULATOR_SERVICE)
                .withExposedPorts(calculatorServiceProperties.getPort())
                .withPrivilegedMode(true)
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
//        this.containerPort = calculatorServiceProperties.getPort();
//        this.containerPort = this.calculatorContainer.getFirstMappedPort();
    }

    public Integer getContainerPort() {
        return this.containerPort;
    }

    public void closeContainer() {
        this.calculatorContainer.close();
    }
}
