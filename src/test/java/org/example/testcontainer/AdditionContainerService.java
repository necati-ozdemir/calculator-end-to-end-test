package org.example.testcontainer;

import org.example.config.AdditionServiceProperties;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Service
public final class AdditionContainerService implements IContainerService {
    private static final DockerImageName ADDITION_SERVICE = DockerImageName
            .parse("mbarkin26/addition-service:latest")
            .asCompatibleSubstituteFor("addition-service");

    private final GenericContainer<?> additionContainer;

    private final Integer containerPort;

    public AdditionContainerService(NetworkService networkService,
                                    AdditionServiceProperties additionServiceProperties) {

        this.additionContainer = new GenericContainer<>(ADDITION_SERVICE)
                .withExposedPorts(additionServiceProperties.getPort())
                .withNetwork(networkService.getNetwork())
                .withEnv("SERVER_PORT", additionServiceProperties.getPort().toString());

        this.additionContainer.start();

        this.containerPort = this.additionContainer.getMappedPort(additionServiceProperties.getPort());
    }

    public Integer getContainerPort() {
        return this.containerPort;
    }

    public void closeContainer() {
        this.additionContainer.close();
    }

    public GenericContainer<?> getAdditionContainer() {
        return additionContainer;
    }
}
