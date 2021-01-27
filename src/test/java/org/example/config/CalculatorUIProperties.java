package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "calculator-ui")
public class CalculatorUIProperties {

    private static final String DEFAULT_IP = "localhost";
    private static final Integer DEFAULT_PORT = 8080;
    private static final String DEFAULT_IMAGE_NAME = "default/image-name:latest";
    private static final String DEFAULT_CAL_SERVICE_ADD_URL_ENV_NAME = "DEFAULT_CAL_SERVICE_ADD_URL_ENV_NAME";
    private static final String DEFAULT_CAL_SERVICE_ADD_URL_ENV_VALUE = "http://calculation-ip:8080/default/addition/api/path";
    private static final String DEFAULT_CAL_SERVICE_SUB_URL_ENV_NAME = "DEFAULT_CAL_SERVICE_SUB_URL_ENV_NAME";
    private static final String DEFAULT_CAL_SERVICE_SUB_URL_ENV_VALUE = "http://calculation-ip:8080/default/subtraction/api/path";
    private static final String DEFAULT_FIRST_VALUE_ELEMENT_ID = "DEFAULT_FIRST_VALUE_ELEMENT_ID";
    private static final String DEFAULT_SECOND_VALUE_ELEMENT_ID = "DEFAULT_SECOND_VALUE_ELEMENT_ID";
    private static final String DEFAULT_ADDITION_BUTTON_ELEMENT_ID = "DEFAULT_ADDITION_BUTTON_ELEMENT_ID";
    private static final String DEFAULT_SUBTRACTION_BUTTON_ELEMENT_ID = "DEFAULT_SUBTRACTION_BUTTON_ELEMENT_ID";
    private static final String DEFAULT_RESULT_VALUE_ELEMENT_ID = "DEFAULT_RESULT_VALUE_ELEMENT_ID";
    private static final String DEFAULT_RESULT_MESSAGE_ELEMENT_ID = "DEFAULT_RESULT_MESSAGE_ELEMENT_ID";

    private String ip = DEFAULT_IP;
    private Integer port = DEFAULT_PORT;
    private String imageName = DEFAULT_IMAGE_NAME;
    private String calculatorServiceAdditionUrlEnvName = DEFAULT_CAL_SERVICE_ADD_URL_ENV_NAME;
    private String calculatorServiceAdditionUrlEnvValue = DEFAULT_CAL_SERVICE_ADD_URL_ENV_VALUE;
    private String calculatorServiceSubtractionUrlEnvName = DEFAULT_CAL_SERVICE_SUB_URL_ENV_NAME;
    private String calculatorServiceSubtractionUrlEnvValue = DEFAULT_CAL_SERVICE_SUB_URL_ENV_VALUE;
    private String firstValueElementId = DEFAULT_FIRST_VALUE_ELEMENT_ID;
    private String secondValueElementId = DEFAULT_SECOND_VALUE_ELEMENT_ID;
    private String additionButtonElementId = DEFAULT_ADDITION_BUTTON_ELEMENT_ID;
    private String subtractionButtonElementId = DEFAULT_SUBTRACTION_BUTTON_ELEMENT_ID;
    private String resultValueElementId = DEFAULT_RESULT_VALUE_ELEMENT_ID;
    private String resultMessageElementId = DEFAULT_RESULT_MESSAGE_ELEMENT_ID;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getCalculatorServiceAdditionUrlEnvName() {
        return calculatorServiceAdditionUrlEnvName;
    }

    public void setCalculatorServiceAdditionUrlEnvName(String calculatorServiceAdditionUrlEnvName) {
        this.calculatorServiceAdditionUrlEnvName = calculatorServiceAdditionUrlEnvName;
    }

    public String getCalculatorServiceAdditionUrlEnvValue() {
        return calculatorServiceAdditionUrlEnvValue;
    }

    public void setCalculatorServiceAdditionUrlEnvValue(String calculatorServiceAdditionUrlEnvValue) {
        this.calculatorServiceAdditionUrlEnvValue = calculatorServiceAdditionUrlEnvValue;
    }

    public String getCalculatorServiceSubtractionUrlEnvName() {
        return calculatorServiceSubtractionUrlEnvName;
    }

    public void setCalculatorServiceSubtractionUrlEnvName(String calculatorServiceSubtractionUrlEnvName) {
        this.calculatorServiceSubtractionUrlEnvName = calculatorServiceSubtractionUrlEnvName;
    }

    public String getCalculatorServiceSubtractionUrlEnvValue() {
        return calculatorServiceSubtractionUrlEnvValue;
    }

    public void setCalculatorServiceSubtractionUrlEnvValue(String calculatorServiceSubtractionUrlEnvValue) {
        this.calculatorServiceSubtractionUrlEnvValue = calculatorServiceSubtractionUrlEnvValue;
    }

    public String getFirstValueElementId() {
        return firstValueElementId;
    }

    public void setFirstValueElementId(String firstValueElementId) {
        this.firstValueElementId = firstValueElementId;
    }

    public String getSecondValueElementId() {
        return secondValueElementId;
    }

    public void setSecondValueElementId(String secondValueElementId) {
        this.secondValueElementId = secondValueElementId;
    }

    public String getAdditionButtonElementId() {
        return additionButtonElementId;
    }

    public void setAdditionButtonElementId(String additionButtonElementId) {
        this.additionButtonElementId = additionButtonElementId;
    }

    public String getSubtractionButtonElementId() {
        return subtractionButtonElementId;
    }

    public void setSubtractionButtonElementId(String subtractionButtonElementId) {
        this.subtractionButtonElementId = subtractionButtonElementId;
    }

    public String getResultValueElementId() {
        return resultValueElementId;
    }

    public void setResultValueElementId(String resultValueElementId) {
        this.resultValueElementId = resultValueElementId;
    }

    public String getResultMessageElementId() {
        return resultMessageElementId;
    }

    public void setResultMessageElementId(String resultMessageElementId) {
        this.resultMessageElementId = resultMessageElementId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
