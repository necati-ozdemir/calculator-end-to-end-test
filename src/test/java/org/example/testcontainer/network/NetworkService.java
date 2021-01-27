package org.example.testcontainer.network;

import org.springframework.stereotype.Service;
import org.testcontainers.containers.Network;

@Service
public final class NetworkService implements INetworkService {

    private final Network network;

    public NetworkService() {
        this.network = Network.newNetwork();
    }

    @Override
    public void closeNetwork() {
        this.network.close();
    }

    @Override
    public Network getNetwork() {
        return network;
    }
}
