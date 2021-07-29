package org.example.testcontainer.recording;

import org.example.testcontainer.selenium.ISeleniumContainerService;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.VncRecordingContainer;

import java.io.File;

//@Service
public class VncRecordingContainerService implements IRecordingContainerService {

    private final VncRecordingContainer vncRecordingContainer;

    public VncRecordingContainerService(ISeleniumContainerService seleniumContainerService) {
        this.vncRecordingContainer = new VncRecordingContainer(seleniumContainerService.getChromeContainer())
                .withFrameRate(20);
    }

    @Override
    public void startContainer() {
        this.vncRecordingContainer.start();
    }

    @Override
    public void stopContainer() {
        this.vncRecordingContainer.stop();
    }

    @Override
    public void saveRecordingToFile(String name) {
        this.vncRecordingContainer.saveRecordingToFile(new File("./target/", name + "_TEST.flv"));
    }

    @Override
    public void closeContainer() {
        this.vncRecordingContainer.close();
    }
}
