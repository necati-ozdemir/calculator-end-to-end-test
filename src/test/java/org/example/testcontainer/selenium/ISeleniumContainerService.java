package org.example.testcontainer.selenium;

import org.example.testcontainer.IContainerService;
import org.testcontainers.containers.BrowserWebDriverContainer;

public interface ISeleniumContainerService extends IContainerService {
    BrowserWebDriverContainer<?> getChromeContainer();
}
