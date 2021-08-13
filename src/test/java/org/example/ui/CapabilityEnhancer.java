package org.example.ui;

import net.serenitybdd.core.webdriver.enhancers.BeforeAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityEnhancer implements BeforeAWebdriverScenario {

    @Override
    public DesiredCapabilities apply(EnvironmentVariables environmentVariables,
                                     SupportedWebDriver driver,
                                     TestOutcome testOutcome,
                                     DesiredCapabilities capabilities) {
        capabilities.setCapability("name", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("se:name", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("fileName", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("se:fileName", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("videoFileName", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("se:videoFileName", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("testName", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("se:testName", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("testFileNameTemplate", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("se:testFileNameTemplate", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        capabilities.setCapability("project", "my project");
        capabilities.setCapability("build", "my build");

        return capabilities;
    }
}