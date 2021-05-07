package org.example.testcontainer.compose;

import org.example.config.CalculatorUIProperties;
import org.example.config.ComposeProperties;
import org.example.testcontainer.IContainerService;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;
import java.time.Duration;

@Service
public final class ComposeContainerService implements IContainerService {

    private final DockerComposeContainer<?> composeContainer;

    public ComposeContainerService(ComposeProperties composeProperties,
                                   CalculatorUIProperties calculatorUIProperties) {
        this.composeContainer = new DockerComposeContainer<>(new File(composeProperties.getPath()))
                .withEnv("WORKER_IP", composeProperties.getWorkerIp())
                .withLocalCompose(true)
                .withExposedService(
                        calculatorUIProperties.getHostname(),
                        calculatorUIProperties.getPort(),
                        Wait.forHttp("/")
                                .withStartupTimeout(Duration.ofSeconds(30))
                );

        this.composeContainer.start();
    }

    @Override
    public void startContainer() {
        this.composeContainer.start();
    }

    @Override
    public void stopContainer() {
        this.composeContainer.stop();
    }

    @Override
    public void closeContainer() {
        this.composeContainer.close();
    }
}
