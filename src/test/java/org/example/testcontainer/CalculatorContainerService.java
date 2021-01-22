package org.example.testcontainer;

import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Service
public final class CalculatorContainerService implements IContainerService {

    private static final DockerImageName CALCULATOR_SERVICE = DockerImageName
            .parse("mbarkin26/calculator-service:latest")
            .asCompatibleSubstituteFor("calculator-service");

    private final GenericContainer<?> calculatorContainer;

    public CalculatorContainerService(NetworkService networkService,
                                      AdditionContainerService additionContainerService,
                                      SubtractionContainerService subtractionContainerService) {

        this.calculatorContainer = new GenericContainer<>(CALCULATOR_SERVICE)
                .withExposedPorts(8072)
                .withNetwork(networkService.getNetwork())
                .withEnv("CALCULATOR_ADDITIONSERVICEURL",
                        "http://10.150.21.212:" + additionContainerService.getPort() + "/api/addition/calculate")
                .withEnv("CALCULATOR_SUBTRACTIONSERVICEURL",
                        "http://10.150.21.212:" + subtractionContainerService.getPort() + "/api/subtraction/calculate")
                .withEnv("SERVER_PORT", "8072")
                .dependsOn(additionContainerService.getAdditionContainer(), subtractionContainerService.getSubtractionContainer());

        calculatorContainer.start();
    }

    public Integer getPort() {
        return this.calculatorContainer.getMappedPort(8072);
    }

    public void closeContainer() {
        this.calculatorContainer.close();
    }
}
