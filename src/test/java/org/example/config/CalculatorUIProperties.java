package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "calculator-ui")
public class CalculatorUIProperties {
    private String ip;
    private Integer port;
    private String calculatorServiceAdditionUrlEnvName;
    private String calculatorServiceAdditionUrlEnvValue;
    private String calculatorServiceSubtractionUrlEnvName;
    private String calculatorServiceSubtractionUrlEnvValue;
    private String firstValueElementId;
    private String secondValueElementId;
    private String additionButtonElementId;
    private String subtractionButtonElementId;
    private String resultValueElementId;
    private String resultMessageElementId;

    public CalculatorUIProperties() {
    }

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
}
