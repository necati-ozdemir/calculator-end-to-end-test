package org.example.testcontainer;

import org.example.config.CalculatorTestProperties;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

@Service
public final class CalculatorUIContainerService implements IContainerService {
    private static final DockerImageName CALCULATOR_UI = DockerImageName
            .parse("mbarkin26/calculator-ui:0.0.1")
            .asCompatibleSubstituteFor("calculator-ui");

    private final GenericContainer<?> calculatorUIContainer;
    private final CalculatorTestProperties calculatorTestProperties;

    public CalculatorUIContainerService(NetworkService networkService,
                                        CalculatorTestProperties calculatorTestProperties,
                                        CalculatorContainerService calculatorContainerService) {

        this.calculatorTestProperties = calculatorTestProperties;

        this.calculatorUIContainer = new GenericContainer<>(CALCULATOR_UI)
                .withExposedPorts(8073)
                .withNetwork(networkService.getNetwork())
                .waitingFor(Wait.forHttp("/"))
                .withEnv("REACT_APP_CALCULATOR_SERVICE_ADDITION_URL",
                        "http://10.150.21.212:" + calculatorContainerService.getPort() + "/calculator/addition")
                .withEnv("REACT_APP_CALCULATOR_SERVICE_SUBTRACTION_URL",
                        "http://10.150.21.212:" + calculatorContainerService.getPort() + "/calculator/subtraction")
                .withEnv("PORT", "8073");

        calculatorUIContainer.start();
    }

    public String getUrl() {
        return "http://" + this.calculatorTestProperties.getWorkerIp() + ":" + this.getPort();
    }

    public Integer getPort() {
        return this.calculatorUIContainer.getMappedPort(8073);
    }

    public void closeContainer() {
        this.calculatorUIContainer.close();
    }
}
