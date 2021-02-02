package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.CalculatorUIProperties;
import org.example.model.CalculateType;
import org.example.selenium.ISeleniumDriverService;
import org.example.testcontainer.recording.IRecordingContainerService;
import org.example.testcontainer.recording.VncRecordingContainerService;
import org.example.testcontainer.selenium.ISeleniumContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration
public final class CalculatorAngryStepDefinitions {

    @Autowired
    private ISeleniumDriverService seleniumDriverService;

    @Autowired
    private CalculatorUIProperties calculatorUIProperties;

    private final IRecordingContainerService recordingContainerService;

    public CalculatorAngryStepDefinitions(ISeleniumContainerService seleniumContainerService) {
        this.recordingContainerService = new VncRecordingContainerService(seleniumContainerService);
    }

    @Before
    public void setUp(Scenario scenario) {
        this.recordingContainerService.startContainer();

        this.seleniumDriverService.getUrlInDriver(this.calculatorUIProperties.getUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        String recordingFileName = scenario.getStatus() + "_" + String.join("_", scenario.getSourceTagNames());

        this.recordingContainerService.saveRecordingToFile(recordingFileName);
        this.recordingContainerService.stopContainer();
    }

    @Given("Either of any value is not given")
    public void givenNumbers() {

        this.seleniumDriverService.setElementValueByElementId(
                this.calculatorUIProperties.getFirstValueElementId(),
                "0"
        );// only first value is given
    }

    @When("Necati wants to perform {} operation")
    public void calculateNumbers(CalculateType calculateType) {
        switch (calculateType) {
            case ADDITION:
                this.seleniumDriverService.clickButtonByElementId(this.calculatorUIProperties.getAdditionButtonElementId());
                break;
            case SUBTRACTION:
                this.seleniumDriverService.clickButtonByElementId(this.calculatorUIProperties.getSubtractionButtonElementId());
                break;
            default:
                throw new UnsupportedOperationException("Calculate Type is unsupported operation: " + calculateType.name());
        }
    }

    @Then("Necati should see a warning notification")
    public void checkingResultNumber() {
        this.seleniumDriverService.waitUntilElementValueIsFill(this.calculatorUIProperties.getResultMessageElementId());

//        assertEquals(this.seleniumDriverService.getElementValueByElementId("resultValue"), resultValue);
        assertEquals(
                this.seleniumDriverService.getElementValueByElementId(this.calculatorUIProperties.getResultMessageElementId()),
                "FAIL"
        );
    }
}
