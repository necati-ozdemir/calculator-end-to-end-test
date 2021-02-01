package org.example.testcontainer.recording;

import org.example.testcontainer.IContainerService;

public interface IVncRecordingContainerService extends IContainerService {

    void startContainer();

    void stopContainer();

    void saveRecordingToFile(String name);
}
