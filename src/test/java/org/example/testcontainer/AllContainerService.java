package org.example.testcontainer;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

import java.io.File;

//@Service
public class AllContainerService {
    private static final DockerImageName ADDITION_SERVICE = DockerImageName.
            parse("mbarkin26/addition-service:latest")
            .asCompatibleSubstituteFor("addition-service");
    private static final DockerImageName SUBTRACTION_SERVICE = DockerImageName
            .parse("mbarkin26/subtraction-service:latest")
            .asCompatibleSubstituteFor("subtraction-service");
    private static final DockerImageName CALCULATOR_SERVICE = DockerImageName
            .parse("mbarkin26/calculator-service:latest")
            .asCompatibleSubstituteFor("calculator-service");
    private static final DockerImageName CALCULATOR_UI = DockerImageName
            .parse("mbarkin26/calculator-ui:0.0.1")
            .asCompatibleSubstituteFor("calculator-ui");

    private Network network;
    private GenericContainer<?> additionContainer;
    private GenericContainer<?> subtractionContainer;
    private GenericContainer<?> calculatorContainer;
    private GenericContainer<?> calculatorUIContainer;
    private BrowserWebDriverContainer<?> chromeContainer;

    public AllContainerService() {
        network = Network.newNetwork();
        additionContainer = new GenericContainer<>(ADDITION_SERVICE)
                .withExposedPorts(8070)
                .withNetwork(network)
                .withEnv("SERVER_PORT", "8070");
        additionContainer.start();

        subtractionContainer = new GenericContainer<>(SUBTRACTION_SERVICE)
                .withExposedPorts(8071)
                .withNetwork(network)
                .withEnv("SERVER_PORT", "8071");
        subtractionContainer.start();

        calculatorContainer = new GenericContainer<>(CALCULATOR_SERVICE)
                .withExposedPorts(8072)
                .withNetwork(network)
                .withEnv("CALCULATOR_ADDITIONSERVICEURL", "http://10.150.21.212:" + additionContainer.getMappedPort(8070) + "/api/addition/calculate")
                .withEnv("CALCULATOR_SUBTRACTIONSERVICEURL", "http://10.150.21.212:" + subtractionContainer.getMappedPort(8071) + "/api/subtraction/calculate")
                .withEnv("SERVER_PORT", "8072")
                .dependsOn(additionContainer, subtractionContainer);
        calculatorContainer.start();

        calculatorUIContainer = new GenericContainer<>(CALCULATOR_UI)
                .withExposedPorts(8073)
                .withNetwork(network)
                .waitingFor(Wait.forHttp("/"))
                .withEnv("REACT_APP_CALCULATOR_SERVICE_ADDITION_URL", "http://10.150.21.212:" + calculatorContainer.getMappedPort(8072) + "/calculator/addition")
                .withEnv("REACT_APP_CALCULATOR_SERVICE_SUBTRACTION_URL", "http://10.150.21.212:" + calculatorContainer.getMappedPort(8072) + "/calculator/subtraction")
                .withEnv("PORT", "8073");
        calculatorUIContainer.start();

        chromeContainer = new BrowserWebDriverContainer<>()
                .withNetwork(network)
                .withNetworkAliases("chrome")
                .withCapabilities(DesiredCapabilities.chrome())
                .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("./target/"));
        chromeContainer.start();
    }

    public void stopContainers() {
        additionContainer.close();
        subtractionContainer.close();
        calculatorContainer.close();
        calculatorUIContainer.close();
        chromeContainer.close();
        network.close();
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public GenericContainer<?> getAdditionContainer() {
        return additionContainer;
    }

    public void setAdditionContainer(GenericContainer<?> additionContainer) {
        this.additionContainer = additionContainer;
    }

    public GenericContainer<?> getSubtractionContainer() {
        return subtractionContainer;
    }

    public void setSubtractionContainer(GenericContainer<?> subtractionContainer) {
        this.subtractionContainer = subtractionContainer;
    }

    public GenericContainer<?> getCalculatorContainer() {
        return calculatorContainer;
    }

    public BrowserWebDriverContainer<?> getChromeContainer() {
        return chromeContainer;
    }

    public void setChromeContainer(BrowserWebDriverContainer<?> chromeContainer) {
        this.chromeContainer = chromeContainer;
    }

    public void setCalculatorContainer(GenericContainer<?> calculatorContainer) {
        this.calculatorContainer = calculatorContainer;
    }

    public GenericContainer<?> getCalculatorUIContainer() {
        return calculatorUIContainer;
    }

    public void setCalculatorUIContainer(GenericContainer<?> calculatorUIContainer) {
        this.calculatorUIContainer = calculatorUIContainer;
    }
}
