package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.example.model.CalculateType;
import org.example.ui.CalculationResult;
import org.example.ui.CalculatorAction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public final class CalculatorHappyStepDefinitionsWithScreenPlayPattern {

    @Steps
    private CalculatorAction calculatorAction;

    @Given("The below numbers are given")
    public void givenNumbers(DataTable dataTable) {
        List<List<String>> givenList = dataTable.asLists(String.class);
        String firstValue = givenList.get(1).get(0);
        String secondValue = givenList.get(1).get(1);
        calculatorAction.forValues(firstValue, secondValue);
    }

    @When("Barkın wants to perform {} those two numbers")
    public void calculateNumbers(CalculateType calculateType) {
        calculatorAction.calculateFor(calculateType.name());
    }

    @Then("Barkın should see result {} and {} message")
    public void checkingResultNumber(String resultValue, String resultMessage) {
        CalculationResult calculationResult = calculatorAction.getResult();
        assertEquals(calculationResult.getValue(), resultValue);
        assertEquals(calculationResult.getMessage(), resultMessage);
    }
}
