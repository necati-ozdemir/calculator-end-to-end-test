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
import static org.assertj.core.api.Assertions.assertThat;

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

        this.seleniumDriverService.selectOptionByElementId(
                this.calculatorUIProperties.getCalculationSelectElementId(),
                calculateType.name()
        );

        this.seleniumDriverService.clickButtonByElementId(
                this.calculatorUIProperties.getCalculationButtonElementId()
        );
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

    @Given("the first value is {} and second value is {}")
    public void theFirstValueIsAndSecondValueIs(String arg0, String arg1) {
        this.seleniumDriverService.setElementValueByElementId(this.calculatorUIProperties.getFirstValueElementId(), arg0);
        this.seleniumDriverService.setElementValueByElementId(this.calculatorUIProperties.getSecondValueElementId(), arg1);
    }

    @When("Murat wants to apply {} on those two numbers")
    public void muratWantsToApplyDIVISIONOnThoseTwoNumbers(CalculateType calculateType) {
        this.seleniumDriverService.selectOptionByElementId(this.calculatorUIProperties
                .getCalculationSelectElementId(), calculateType.name());
        this.seleniumDriverService.clickButtonByElementId(this.calculatorUIProperties.getCalculationButtonElementId());
    }

    @Then("Murat should see a fail message")
    public void muratShouldSeeAFailMessage() {
        this.seleniumDriverService.waitUntilElementValueIsFill(this.calculatorUIProperties.getResultMessageElementId());
        assertEquals(this.seleniumDriverService.
                getElementValueByElementId(this.calculatorUIProperties.getResultMessageElementId()), "FAILED: Division with 0");

        assertEquals(this.seleniumDriverService.
                getElementValueByElementId(this.calculatorUIProperties.getResultValueElementId()), "-1");
    }

    @When("Zumrut wants to apply {} on those two numbers")
    public void zumrutWantsToApplyMULTIPLICATIONOnThoseTwoNumbers(CalculateType calculateType) {
        this.seleniumDriverService.selectOptionByElementId(this.calculatorUIProperties
                .getCalculationSelectElementId(), calculateType.name());
        this.seleniumDriverService.clickButtonByElementId(this.calculatorUIProperties.getCalculationButtonElementId());
    }

    @Then("Zumrut should see a fail message")
    public void zumrutShouldSeeAFailMessage() {
        this.seleniumDriverService.waitUntilElementValueIsFill(this.calculatorUIProperties.getResultMessageElementId());
        assertThat(this.seleniumDriverService.
                getElementValueByElementId(this.calculatorUIProperties.getResultMessageElementId()))
                .startsWith("FAIL: ");

        assertEquals(this.seleniumDriverService.
                getElementValueByElementId(this.calculatorUIProperties.getResultValueElementId()), "");
    }
}
