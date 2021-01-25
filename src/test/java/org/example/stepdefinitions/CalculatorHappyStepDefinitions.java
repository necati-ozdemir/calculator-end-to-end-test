package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.CalculatorUIProperties;
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
public final class CalculatorHappyStepDefinitions {

    @Autowired
    private ISeleniumDriverService seleniumDriverService;

    @Autowired
    private CalculatorUIProperties calculatorUIProperties;

    @Autowired
    private CalculatorUIContainerService calculatorUIContainerService;

    @Given("{} and {} are given")
    public void givenNumbers(String firstValue, String secondValue) {
        this.seleniumDriverService.getUrlInDriver(this.calculatorUIContainerService.getUrl());

        this.seleniumDriverService.setElementValueByElementId(
                this.calculatorUIProperties.getFirstValueElementId(),
                firstValue
        );
        this.seleniumDriverService.setElementValueByElementId(
                this.calculatorUIProperties.getSecondValueElementId(),
                secondValue
        );
    }

    @When("Barkın wants to {} those two numbers")
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

    @Then("Barkın should see {} result and {} message")
    public void checkingResultNumber(String resultValue, String resultMessage) {
        this.seleniumDriverService.waitUntilElementValueIsFill(this.calculatorUIProperties.getResultValueElementId());

        assertEquals(this.seleniumDriverService.getElementValueByElementId(
                this.calculatorUIProperties.getResultValueElementId()),
                resultValue
        );
        assertEquals(this.seleniumDriverService.getElementValueByElementId(
                this.calculatorUIProperties.getResultMessageElementId()),
                resultMessage
        );
    }

    @DynamicPropertySource//This annotation lets you override Spring configuration properties programmatically
    static void properties(DynamicPropertyRegistry registry) {
        // registry.add(key, value);
    }
}
