package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.testcontainer.CalculatorContainers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest
@ContextConfiguration
public class AdditionHappyStepDefinitions {

    @Autowired
    private CalculatorContainers calculatorContainers;

    @DynamicPropertySource//This annotation lets you override Spring configuration properties programmatically
    static void properties(DynamicPropertyRegistry registry) {
        // registry.add(key, value);
    }

    @Given("{} and {} are given")
    public void givenNumbers(Integer numberOne, Integer numberTwo) {
        System.out.println("Given " + numberOne + " " + numberTwo + " " + this.calculatorContainers.getCalculatorContainer().getDockerImageName());
    }

    @When("Mutlu wants to add those two numbers")
    public void addingNumbers() {
        System.out.println("When");
    }

    @Then("Mutlu should see {} result")
    public void checkingResultNumber(Integer result) {
        System.out.println("Then " + result);
    }
}
