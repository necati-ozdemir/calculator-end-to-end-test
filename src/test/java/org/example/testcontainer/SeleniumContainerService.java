package org.example.testcontainer;

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
