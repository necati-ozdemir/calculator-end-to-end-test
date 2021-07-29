package org.example.stepdefinitions;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public final class CalculatorHappyStepDefinitions {

//    @Autowired
//    private ISeleniumDriverService seleniumDriverService;
//
//    @Steps
//    private ValueAction valueAction;
//
//    @Autowired
//    private CalculatorUIProperties calculatorUIProperties;
//
//    @Autowired
//    private IRecordingContainerService recordingContainerService;
//
//    @Before
//    public void setUp(Scenario scenario) {
//        this.recordingContainerService.startContainer();
//        this.seleniumDriverService.getUrlInDriver(this.calculatorUIProperties.getUrl());
//    }
//
//    @After
//    public void tearDown(Scenario scenario) {
//        String recordingFileName = scenario.getStatus() + "_" + String.join("_", scenario.getSourceTagNames());
//
//        this.recordingContainerService.saveRecordingToFile(recordingFileName);
//        this.recordingContainerService.stopContainer();
//    }
//
//    @Given("The below numbers are given")
//    public void givenNumbers(DataTable dataTable) {
//        List<List<String>> givenList = dataTable.asLists(String.class);
//        String firstValue = givenList.get(1).get(0);
//        String secondValue = givenList.get(1).get(1);
//        valueAction.as(firstValue, secondValue);
//
////        this.seleniumDriverService.setElementValueByElementId(
////                this.calculatorUIProperties.getFirstValueElementId(),
////                firstValue
////        );
////        this.seleniumDriverService.setElementValueByElementId(
////                this.calculatorUIProperties.getSecondValueElementId(),
////                secondValue
////        );
//    }
//
//    @When("Barkın wants to perform {} those two numbers")
//    public void calculateNumbers(CalculateType calculateType) {
//        valueAction.submit(calculateType.name());
//
////        this.seleniumDriverService.selectOptionByElementId(
////                this.calculatorUIProperties.getCalculationSelectElementId(),
////                calculateType.name()
////        );
////
////        this.seleniumDriverService.clickButtonByElementId(
////                this.calculatorUIProperties.getCalculationButtonElementId()
////        );
//    }
//
//    @Then("Barkın should see result {} and {} message")
//    public void checkingResultNumber(String resultValue, String resultMessage) {
//        this.seleniumDriverService.waitUntilElementValueIsFill(this.calculatorUIProperties.getResultValueElementId());
//
//        assertEquals(
//                this.seleniumDriverService.getElementValueByElementId(this.calculatorUIProperties.getResultValueElementId()),
//                resultValue
//        );
//        assertEquals(
//                this.seleniumDriverService.getElementValueByElementId(this.calculatorUIProperties.getResultMessageElementId()),
//                resultMessage
//        );
//    }
//
//    @Given("Numbers are given {} and {}")
//    public void numbersAreGivenAnd(String first, String secondValue) {
////        this.seleniumDriverService.getUrlInDriver(this.calculatorUIProperties.getUrl());
//
//        this.seleniumDriverService.setElementValueByElementId(
//                this.calculatorUIProperties.getFirstValueElementId(),
//                first
//        );
//        this.seleniumDriverService.setElementValueByElementId(
//                this.calculatorUIProperties.getSecondValueElementId(),
//                secondValue
//        );
//    }
//
//    @When("Zumrut wants to perform {} those two numbers")
//    public void zumrutWantsToPerformMULTIPLICATIONThoseTwoNumbers(CalculateType calculateType) {
//        this.seleniumDriverService.selectOptionByElementId(
//                this.calculatorUIProperties.getCalculationSelectElementId(),
//                calculateType.name()
//        );
//
//        this.seleniumDriverService.clickButtonByElementId(
//                this.calculatorUIProperties.getCalculationButtonElementId()
//        );
//    }
//
//    @Then("Zumrut should see result {} and {} message")
//    public void zumrutShouldSeeResultResultAndResultMessageMessage(String resultValue, String resultMessage) {
//        this.seleniumDriverService.waitUntilElementValueIsFill(this.calculatorUIProperties.getResultValueElementId());
//
//        assertEquals(
//                this.seleniumDriverService.getElementValueByElementId(this.calculatorUIProperties.getResultValueElementId()),
//                resultValue
//        );
//        assertEquals(
//                this.seleniumDriverService.getElementValueByElementId(this.calculatorUIProperties.getResultMessageElementId()),
//                resultMessage
//        );
//    }
}
