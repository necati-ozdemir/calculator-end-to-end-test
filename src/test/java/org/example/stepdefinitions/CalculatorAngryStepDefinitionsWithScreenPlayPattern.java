package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.example.model.CalculateType;
import org.example.ui.CalculationResult;
import org.example.ui.CalculatorAction;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public final class CalculatorAngryStepDefinitionsWithScreenPlayPattern {

    @Steps
    private CalculatorAction calculatorAction;

    @Given("Either of any value is not given")
    public void givenNumbers() {
        calculatorAction.forValues("0", "");

    }

    @When("Necati wants to perform {} operation")
    public void calculateNumbers(CalculateType calculateType) {
        calculatorAction.calculateFor(calculateType.name());
    }

    @Then("Necati should see a warning notification")
    public void checkingResultNumber() {
        CalculationResult calculationResult = calculatorAction.getResult();
        assertEquals(calculationResult.getMessage(), "FAIL");
    }
}
