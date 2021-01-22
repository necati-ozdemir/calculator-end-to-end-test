package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.CalculatorTestProperties;
import org.example.model.CalculateType;
import org.example.selenium.ISeleniumDriverService;
import org.example.testcontainer.CalculatorUIContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration
public final class CalculatorAngryStepDefinitions {

    @Autowired
    private ISeleniumDriverService seleniumDriverService;

    @Autowired
    private CalculatorUIContainerService calculatorUIContainerService;

    @Autowired
    private CalculatorTestProperties calculatorTestProperties;

    @Given("either of any value is not given")
    public void givenNumbers() {
        this.seleniumDriverService.getUrlInDriver(this.calculatorUIContainerService.getUrl());

        this.seleniumDriverService.setElementValueByElementId("firstValue", "0");// only first value is given
    }

    @When("Necati wants to continue to {} operation")
    public void calculateNumbers(CalculateType calculateType) {
        switch (calculateType) {
            case ADDITION:
                this.seleniumDriverService.clickButtonByElementId("additionButton");
                break;
            case SUBTRACTION:
                this.seleniumDriverService.clickButtonByElementId("subtractionButton");
                break;
            default:
                throw new UnsupportedOperationException("Calculate Type is unsupported operation: " + calculateType.name());
        }
    }

    @Then("Necati should see a warning notification")
    public void checkingResultNumber() {
        this.seleniumDriverService.waitUntilElementValueIsFill("resultValue");

//        assertEquals(this.seleniumDriverService.getElementValueByElementId("resultValue"), resultValue);
        assertEquals(this.seleniumDriverService.getElementValueByElementId("resultMessage"), "FAIL");
    }

    @DynamicPropertySource//This annotation lets you override Spring configuration properties programmatically
    static void properties(DynamicPropertyRegistry registry) {
        // registry.add(key, value);
    }
}
