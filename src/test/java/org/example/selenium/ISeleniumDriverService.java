package org.example.selenium;

public interface ISeleniumDriverService {
    String getElementValueByElementId(String elementId);

    void clickButtonByElementId(String elementId);

    void selectOptionByElementId(String elementId, String option);

    void setElementValueByElementId(String elementId, String value);

    void waitUntilElementValueIsFill(String elementId);

    void getUrlInDriver(String url);

    void closeDriver();
}
