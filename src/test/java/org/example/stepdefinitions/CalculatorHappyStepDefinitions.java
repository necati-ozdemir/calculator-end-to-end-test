package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.CalculatorUIProperties;
import org.example.model.CalculateType;
import org.example.selenium.ISeleniumDriverService;
import org.example.testcontainer.calculator.CalculatorUIContainerService;
import org.example.testcontainer.recording.IRecordingContainerService;
import org.example.testcontainer.recording.VncRecordingContainerService;
import org.example.testcontainer.selenium.ISeleniumContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration
public final class CalculatorHappyStepDefinitions {

    @Autowired
    private ISeleniumDriverService seleniumDriverService;

    @Autowired
    private CalculatorUIProperties calculatorUIProperties;

    @Autowired
    private CalculatorUIContainerService calculatorUIContainerService;

    private final IRecordingContainerService recordingContainerService;

    public CalculatorHappyStepDefinitions(ISeleniumContainerService seleniumContainerService) {
        this.recordingContainerService = new VncRecordingContainerService(seleniumContainerService);
    }

    @Before
    public void setUp(Scenario scenario) {
        this.recordingContainerService.startContainer();

        this.seleniumDriverService.getUrlInDriver(this.calculatorUIContainerService.getUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        String recordingFileName = scenario.getStatus() + "_" + String.join("_", scenario.getSourceTagNames());

        this.recordingContainerService.saveRecordingToFile(recordingFileName);
        this.recordingContainerService.stopContainer();
    }

    @Given("The below numbers are given")
    public void givenNumbers(DataTable dataTable) {
        List<List<String>> givenList = dataTable.asLists(String.class);
        String firstValue = givenList.get(1).get(0);
        String secondValue = givenList.get(1).get(1);

        this.seleniumDriverService.setElementValueByElementId(
                this.calculatorUIProperties.getFirstValueElementId(),
                firstValue
        );
        this.seleniumDriverService.setElementValueByElementId(
                this.calculatorUIProperties.getSecondValueElementId(),
                secondValue
        );
    }

    @When("Barkın wants to perform {} those two numbers")
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

    @Then("Barkın should see result {} and {} message")
    public void checkingResultNumber(String resultValue, String resultMessage) {
        this.seleniumDriverService.waitUntilElementValueIsFill(this.calculatorUIProperties.getResultValueElementId());

        assertEquals(
                this.seleniumDriverService.getElementValueByElementId(this.calculatorUIProperties.getResultValueElementId()),
                resultValue
        );
        assertEquals(
                this.seleniumDriverService.getElementValueByElementId(this.calculatorUIProperties.getResultMessageElementId()),
                resultMessage
        );
    }

    @Given("Numbers are given {} and {}")
    public void numbersAreGivenAnd(String first, String secondValue) {

        this.seleniumDriverService.setElementValueByElementId(
                this.calculatorUIProperties.getFirstValueElementId(),
                first
        );
        this.seleniumDriverService.setElementValueByElementId(
                this.calculatorUIProperties.getSecondValueElementId(),
                secondValue
        );
    }
}
