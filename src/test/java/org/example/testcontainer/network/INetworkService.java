package org.example.testcontainer.network;

import org.testcontainers.containers.Network;

public interface INetworkService {
    void closeNetwork();

    Network getNetwork();
}
