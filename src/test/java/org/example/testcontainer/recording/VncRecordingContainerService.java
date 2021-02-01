package org.example.testcontainer.recording;

import org.example.testcontainer.selenium.SeleniumContainerService;
import org.testcontainers.containers.VncRecordingContainer;

import java.io.File;

public class VncRecordingContainerService implements IRecordingContainerService {

    private final VncRecordingContainer vnc;

    public VncRecordingContainerService(SeleniumContainerService seleniumContainerService) {
        this.vnc = new VncRecordingContainer(seleniumContainerService.getChromeContainer())
                .withFrameRate(20);
    }

    @Override
    public Integer getContainerPort() {
        return this.vnc.getVncPort();
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
