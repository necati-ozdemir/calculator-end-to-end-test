package org.example.ui;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

@DefaultUrl("/calculator")
class CalculatorPage extends PageObject {
//    static final By EMAIL = By.id("email");
//    static final By PASSWORD = By.id("password");
//    static final By LOGIN_BUTTON = By.id("login-button");

    @FindBy(id="firstValue")
    WebElement firstValue;

    @FindBy(id="secondValue")
    WebElement secondValue;

    @FindBy(id="calculationSelect")
    WebElement calculationSelect;

    @FindBy(id="calculationButton")
    WebElement calculationButton;

    @FindBy(id="resultValue")
    WebElement resultValue;

    @FindBy(id="resultMessage")
    WebElement resultMessage;

    public void enterValues(String firstVal, String secondVal) {
        open();
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(firstValue));
        firstValue.sendKeys(firstVal);
        secondValue.sendKeys(secondVal);
    }

    public void submit(String calculationType) {
        calculationSelect.click();
        getDriver().findElement(By.id(calculationType)).click();
        calculationButton.click();
    }

    public CalculationResult getResultWithMessage() {
        new WebDriverWait(getDriver(), 20).until( (webDriver -> !Objects.equals( resultMessage.getAttribute("value"), "" )));
        String value = resultValue.getAttribute("value");
        String message = resultMessage.getAttribute("value");
        return new CalculationResult(value, message);
    }
}
