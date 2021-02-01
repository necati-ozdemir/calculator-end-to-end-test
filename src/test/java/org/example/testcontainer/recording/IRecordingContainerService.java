package org.example.testcontainer.recording;

import org.example.testcontainer.IContainerService;

public interface IRecordingContainerService extends IContainerService {

    void saveRecordingToFile(String name);
}
