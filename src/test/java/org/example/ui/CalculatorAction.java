package org.example.ui;

import net.thucydides.core.annotations.Step;

public class CalculatorAction {

    private CalculatorPage calculatorPage;

    @Step("Enter values as {0} {1}")
    public void forValues(String firstValue, String secondValue) {
        calculatorPage.enterValues(firstValue, secondValue);
    }

    @Step("Calculate for {0}")
    public void calculateFor(String name) {
        calculatorPage.submit(name);
    }

    public CalculationResult getResult() {
        return calculatorPage.getResultWithMessage();
    }
}
