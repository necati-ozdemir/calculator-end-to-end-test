package org.example.testcontainer;

import org.springframework.stereotype.Component;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.utility.DockerImageName;

@Component
public class CalculatorContainers {
    private static final DockerImageName ADDITION_SERVICE = DockerImageName.
            parse("registry.hub.docker.com/addition-service:latest")
            .asCompatibleSubstituteFor("addition-service");
    private static final DockerImageName SUBTRACTION_SERVICE = DockerImageName
            .parse("registry.hub.docker.com/subtraction-service:latest")
            .asCompatibleSubstituteFor("subtraction-service");
    private static final DockerImageName CALCULATOR_SERVICE = DockerImageName
            .parse("registry.hub.docker.com/calculator-service:latest")
            .asCompatibleSubstituteFor("calculator-service");
//    private static final DockerImageName SELENIUM_SERVICE = DockerImageName
//            .parse("selenium/node-chrome:latest")
//            .asCompatibleSubstituteFor("node-chrome");


    private Network network;
    private GenericContainer<?> additionContainer;
    private GenericContainer<?> subtractionContainer;
    private GenericContainer<?> calculatorContainer;
//    private static BrowserWebDriverContainer<?> chromeContainer;

    public CalculatorContainers() {
        network = Network.newNetwork();
        additionContainer = new GenericContainer<>(ADDITION_SERVICE)
                .withExposedPorts(8070)
                .withNetwork(network)
                .withEnv("SERVER_PORT", "8070")
                .withEnv("SERVER_ADDRESS", "localhost");

        subtractionContainer = new GenericContainer<>(SUBTRACTION_SERVICE)
                .withExposedPorts(8071)
//                .withExtraHost("subtraction-service","10.150.17.73")
                .withNetwork(network)
                .withEnv("SERVER_PORT", "8071")
                .withEnv("SERVER_ADDRESS", "localhost");

        calculatorContainer = new GenericContainer<>(CALCULATOR_SERVICE)
                .withExposedPorts(8072)
                .withNetwork(network)
                .withEnv("SERVER_PORT", "8072")
                .withEnv("SERVER_ADDRESS", "localhost");

//        chromeContainer = new BrowserWebDriverContainer<>(SELENIUM_SERVICE)
//                .withNetwork(network)
//                .withNetworkAliases("chrome")
//                .withCapabilities(DesiredCapabilities.chrome())
//                .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("./target/"));
//                .withExposedPorts(8072)
//                .withNetwork(network)
//                .withEnv("SERVER_PORT", "8072")
//                .withEnv("SERVER_ADDRESS", "localhost");

        additionContainer.start();
        subtractionContainer.start();
        calculatorContainer.start();
//        chromeContainer.start();
    }

    public void stopContainers(){
        additionContainer.close();
        subtractionContainer.close();
        calculatorContainer.close();
//        chromeContainer.close();
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

    public void setCalculatorContainer(GenericContainer<?> calculatorContainer) {
        this.calculatorContainer = calculatorContainer;
    }
}
