package org.example.testcontainer;

import org.springframework.stereotype.Service;
import org.testcontainers.containers.Network;

@Service
public final class NetworkService {

    private final Network network;

    public NetworkService() {
        this.network = Network.newNetwork();
    }

    public void closeNetwork() {
        this.network.close();
    }

    public Network getNetwork() {
        return network;
    }
}
