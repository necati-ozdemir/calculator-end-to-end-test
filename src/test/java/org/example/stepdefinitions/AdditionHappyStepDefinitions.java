package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.testcontainer.CalculatorContainerService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration
public class AdditionHappyStepDefinitions {

    @Autowired
    private CalculatorContainerService calculatorContainerService;

    @DynamicPropertySource//This annotation lets you override Spring configuration properties programmatically
    static void properties(DynamicPropertyRegistry registry) {
        // registry.add(key, value);
    }

    @Given("{} and {} are given")
    public void givenNumbers(Integer numberOne, Integer numberTwo) {
        System.out.println("Given " + numberOne + " " + numberTwo + " " + this.calculatorContainerService.getCalculatorContainer().getDockerImageName());
    }

    @When("Mutlu wants to add those two numbers")
    public void addingNumbers() {
        System.out.println("When");
    }

    @Then("Mutlu should see {} result")
    public void checkingResultNumber(Integer result) {
        System.out.println("Then " + result);

        this.calculatorContainerService.stopContainers();
    }
}
