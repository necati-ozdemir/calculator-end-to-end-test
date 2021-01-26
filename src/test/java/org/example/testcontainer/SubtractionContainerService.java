package org.example.testcontainer;

import org.example.config.SubtractionServiceProperties;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Service
public final class SubtractionContainerService implements IContainerService {
    private static final DockerImageName SUBTRACTION_SERVICE = DockerImageName
            .parse("mbarkin26/subtraction-service:latest")
            .asCompatibleSubstituteFor("subtraction-service");

    private final GenericContainer<?> subtractionContainer;

    private final Integer containerPort;

    public SubtractionContainerService(NetworkService networkService,
                                       SubtractionServiceProperties subtractionServiceProperties) {

        this.subtractionContainer = new GenericContainer<>(SUBTRACTION_SERVICE)
                .withExposedPorts(subtractionServiceProperties.getPort())
                .withNetwork(networkService.getNetwork())
                .withEnv("SERVER_PORT", subtractionServiceProperties.getPort().toString());

        this.subtractionContainer.start();

        this.containerPort = this.subtractionContainer.getMappedPort(subtractionServiceProperties.getPort());
    }

    public Integer getContainerPort() {
        return this.containerPort;
    }

    public void closeContainer() {
        this.subtractionContainer.close();
    }

    public GenericContainer<?> getSubtractionContainer() {
        return subtractionContainer;
    }
}
