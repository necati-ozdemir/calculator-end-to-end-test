package org.example.testcontainer.calculator;

import org.example.config.AdditionServiceProperties;
import org.example.testcontainer.IContainerService;
import org.example.testcontainer.network.INetworkService;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Service
public final class AdditionContainerService implements IContainerService {

    private final Integer containerPort;

    private final GenericContainer<?> additionContainer;

    public AdditionContainerService(INetworkService networkService,
                                    AdditionServiceProperties additionServiceProperties) {

        DockerImageName additionServiceImage = DockerImageName
                .parse(additionServiceProperties.getImageName())
                .asCompatibleSubstituteFor("addition-service");

        this.additionContainer = new GenericContainer<>(additionServiceImage)
                .withExposedPorts(additionServiceProperties.getPort())
                .withNetwork(networkService.getNetwork())
                .withEnv("SERVER_PORT", additionServiceProperties.getPort().toString());

        this.additionContainer.start();

        this.containerPort = this.additionContainer.getMappedPort(additionServiceProperties.getPort());
    }

    @Override
    public Integer getContainerPort() {
        return this.containerPort;
    }

    @Override
    public void startContainer() {
        this.additionContainer.start();
    }

    @Override
    public void stopContainer() {
        this.additionContainer.stop();
    }

    @Override
    public void closeContainer() {
        this.additionContainer.close();
    }

    public GenericContainer<?> getAdditionContainer() {
        return additionContainer;
    }
}
