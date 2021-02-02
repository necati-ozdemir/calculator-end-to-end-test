package org.example.testcontainer.selenium;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.Network;

@Service
public final class SeleniumContainerService implements ISeleniumContainerService {

    private final BrowserWebDriverContainer<?> chromeContainer;

    public SeleniumContainerService() {
        this.chromeContainer = new BrowserWebDriverContainer<>()
                .withNetwork(Network.SHARED)
                .withNetworkAliases("chrome")
                .withCapabilities(DesiredCapabilities.chrome())
                .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.SKIP, null);

        this.chromeContainer.start();
    }

    @Override
    public void startContainer() {
        this.chromeContainer.start();
    }

    @Override
    public void stopContainer() {
        this.chromeContainer.stop();
    }

    @Override
    public void closeContainer() {
        this.chromeContainer.close();
    }

    @Override
    public BrowserWebDriverContainer<?> getChromeContainer() {
        return chromeContainer;
    }
}
