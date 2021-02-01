package org.example.testcontainer.selenium;

import org.example.testcontainer.IContainerService;
import org.example.testcontainer.network.INetworkService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;
import org.testcontainers.containers.BrowserWebDriverContainer;

@Service
public final class SeleniumContainerService implements IContainerService {

    private final BrowserWebDriverContainer<?> chromeContainer;

    public SeleniumContainerService(INetworkService networkService) {
        this.chromeContainer = new BrowserWebDriverContainer<>()
                .withNetwork(networkService.getNetwork())
                .withNetworkAliases("chrome")
                .withCapabilities(DesiredCapabilities.chrome())
                .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.SKIP, null);

        this.chromeContainer.start();
    }

    @Override
    public Integer getContainerPort() {
        return this.chromeContainer.getFirstMappedPort();
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

    public BrowserWebDriverContainer<?> getChromeContainer() {
        return chromeContainer;
    }
}
