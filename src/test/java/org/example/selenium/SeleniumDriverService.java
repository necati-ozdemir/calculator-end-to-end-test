package org.example.selenium;

import org.example.testcontainer.SeleniumContainerService;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public final class SeleniumDriverService implements ISeleniumDriverService {

    private final WebDriverWait wait;
    private final RemoteWebDriver chromeDriver;

    public SeleniumDriverService(SeleniumContainerService seleniumContainerService) {

        this.chromeDriver = seleniumContainerService.getChromeContainer().getWebDriver();
        this.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        this.wait = new WebDriverWait(this.chromeDriver, 3);// waits max of 3 sec
    }

    @Override
    public String getElementValueByElementId(String elementId) {
        return this.chromeDriver.findElementById(elementId).getAttribute("value");
    }

    @Override
    public void clickButtonByElementId(String elementId) {
        this.chromeDriver.findElementById(elementId).click();
    }

    @Override
    public void setElementValueByElementId(String elementId, String value) {
        this.chromeDriver.findElementById(elementId).sendKeys(value);
    }

    @Override
    public void waitUntilElementValueIsFill(String elementId) {
        this.wait.until((webDriver -> !Objects.equals(
                webDriver
                        .findElement(By.id(elementId))
                        .getAttribute("value"),
                ""
        )));
    }

    @Override
    public void getUrlInDriver(String url) {
        this.chromeDriver.get(url);
    }

    @Override
    public void closeDriver() {
        this.chromeDriver.quit();
    }
}
