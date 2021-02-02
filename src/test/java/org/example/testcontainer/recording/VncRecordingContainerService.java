package org.example.testcontainer.recording;

import org.example.testcontainer.selenium.ISeleniumContainerService;
import org.testcontainers.containers.VncRecordingContainer;

import java.io.File;

public final class VncRecordingContainerService implements IRecordingContainerService {

    private final VncRecordingContainer vnc;

    public VncRecordingContainerService(ISeleniumContainerService seleniumContainerService) {
        this.vnc = new VncRecordingContainer(seleniumContainerService.getChromeContainer())
                .withFrameRate(20);
    }

    @Override
    public void startContainer() {
        this.vnc.start();
    }

    @Override
    public void stopContainer() {
        this.vnc.stop();
    }

    @Override
    public void saveRecordingToFile(String name) {
        this.vnc.saveRecordingToFile(new File("./target/", name + "_TEST.flv"));
    }

    @Override
    public void closeContainer() {
        this.vnc.close();
    }
}
