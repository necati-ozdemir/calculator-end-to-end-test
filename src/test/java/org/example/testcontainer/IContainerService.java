package org.example.testcontainer;

public interface IContainerService {

    Integer getContainerPort();

    void startContainer();

    void stopContainer();

    void closeContainer();
}
