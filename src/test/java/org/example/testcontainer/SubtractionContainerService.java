package org.example.testcontainer;

import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Service
public final class SubtractionContainerService implements IContainerService {
    private static final DockerImageName SUBTRACTION_SERVICE = DockerImageName
            .parse("mbarkin26/subtraction-service:latest")
            .asCompatibleSubstituteFor("subtraction-service");

    private final GenericContainer<?> subtractionContainer;

    public SubtractionContainerService(NetworkService networkService) {
        this.subtractionContainer = new GenericContainer<>(SUBTRACTION_SERVICE)
                .withExposedPorts(8071)
                .withNetwork(networkService.getNetwork())
                .withEnv("SERVER_PORT", "8071");

        this.subtractionContainer.start();
    }

    public Integer getPort() {
        return this.subtractionContainer.getMappedPort(8071);
    }

    public void closeContainer() {
        this.subtractionContainer.close();
    }

    public GenericContainer<?> getSubtractionContainer() {
        return subtractionContainer;
    }
}
