package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    private CalculatorUIContainerService calculatorUIContainerService;


    @Given("{} and {} are given")
    public void givenNumbers(String firstValue, String secondValue) {
        this.seleniumDriverService.getUrlInDriver("http://10.150.21.212:" + this.calculatorUIContainerService.getPort());

        this.seleniumDriverService.setElementValueByElementId("firstValue", firstValue);
        this.seleniumDriverService.setElementValueByElementId("secondValue", secondValue);
    }

    @When("Barkın wants to {} those two numbers")
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

    @Then("Barkın should see {} result and {} message")
    public void checkingResultNumber(String resultValue, String resultMessage) {
        this.seleniumDriverService.waitUntilElementValueIsFill("resultValue");

        assertEquals(this.seleniumDriverService.getElementValueByElementId("resultValue"), resultValue);
        assertEquals(this.seleniumDriverService.getElementValueByElementId("resultMessage"), resultMessage);
    }

    @DynamicPropertySource//This annotation lets you override Spring configuration properties programmatically
    static void properties(DynamicPropertyRegistry registry) {
        // registry.add(key, value);
    }
}
