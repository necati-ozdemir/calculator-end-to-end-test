package org.example.testcontainer;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

@Service
public final class SeleniumContainerService implements IContainerService {

    private final BrowserWebDriverContainer<?> chromeContainer;

    public SeleniumContainerService(NetworkService networkService) {
        this.chromeContainer = new BrowserWebDriverContainer<>()
                .withNetwork(networkService.getNetwork())
                .withPrivilegedMode(true)
                .withNetworkAliases("chrome")
                .withCapabilities(DesiredCapabilities.chrome())
                .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("./target/"));

        this.chromeContainer.start();
    }

    public Integer getContainerPort() {
        return this.chromeContainer.getFirstMappedPort();
    }

    public void closeContainer() {
        this.chromeContainer.close();
    }

    public BrowserWebDriverContainer<?> getChromeContainer() {
        return chromeContainer;
    }
}
