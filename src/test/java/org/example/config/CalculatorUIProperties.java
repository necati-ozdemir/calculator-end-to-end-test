package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "calculator-ui")
public class CalculatorUIProperties {

    private static final String DEFAULT_IP = "localhost";
    private static final Integer DEFAULT_PORT = 8080;
    private static final String DEFAULT_HOSTNAME = "default-calculator-ui";
    private static final String DEFAULT_FIRST_VALUE_ELEMENT_ID = "DEFAULT_FIRST_VALUE_ELEMENT_ID";
    private static final String DEFAULT_SECOND_VALUE_ELEMENT_ID = "DEFAULT_SECOND_VALUE_ELEMENT_ID";
    private static final String DEFAULT_CALCULATION_SELECT_ELEMENT_ID = "DEFAULT_CALCULATION_SELECT_ELEMENT_ID";
    private static final String DEFAULT_CALCULATION_BUTTON_ELEMENT_ID = "DEFAULT_CALCULATION_BUTTON_ELEMENT_ID";
    private static final String DEFAULT_RESULT_VALUE_ELEMENT_ID = "DEFAULT_RESULT_VALUE_ELEMENT_ID";
    private static final String DEFAULT_RESULT_MESSAGE_ELEMENT_ID = "DEFAULT_RESULT_MESSAGE_ELEMENT_ID";

    private String ip = DEFAULT_IP;
    private Integer port = DEFAULT_PORT;
    private String hostname = DEFAULT_HOSTNAME;
    private String firstValueElementId = DEFAULT_FIRST_VALUE_ELEMENT_ID;
    private String secondValueElementId = DEFAULT_SECOND_VALUE_ELEMENT_ID;
    private String calculationSelectElementId = DEFAULT_CALCULATION_SELECT_ELEMENT_ID;
    private String calculationButtonElementId = DEFAULT_CALCULATION_BUTTON_ELEMENT_ID;
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

    public String getCalculationSelectElementId() {
        return calculationSelectElementId;
    }

    public void setCalculationSelectElementId(String calculationSelectElementId) {
        this.calculationSelectElementId = calculationSelectElementId;
    }

    public String getCalculationButtonElementId() {
        return calculationButtonElementId;
    }

    public void setCalculationButtonElementId(String calculationButtonElementId) {
        this.calculationButtonElementId = calculationButtonElementId;
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

    public String getUrl() {
        return "http://" + this.ip + ":" + this.port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
