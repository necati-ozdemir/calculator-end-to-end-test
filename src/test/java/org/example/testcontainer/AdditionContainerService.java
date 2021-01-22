package org.example.testcontainer;

import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Service
public final class AdditionContainerService implements IContainerService {
    private static final DockerImageName ADDITION_SERVICE = DockerImageName.
            parse("mbarkin26/addition-service:latest")
            .asCompatibleSubstituteFor("addition-service");

    private final GenericContainer<?> additionContainer;

    public AdditionContainerService(NetworkService networkService) {
        this.additionContainer = new GenericContainer<>(ADDITION_SERVICE)
                .withExposedPorts(8070)
                .withNetwork(networkService.getNetwork())
                .withEnv("SERVER_PORT", "8070");

        this.additionContainer.start();
    }

    public Integer getPort() {
        return this.additionContainer.getMappedPort(8070);
    }

    public void closeContainer() {
        this.additionContainer.close();
    }

    public GenericContainer<?> getAdditionContainer() {
        return additionContainer;
    }
}
