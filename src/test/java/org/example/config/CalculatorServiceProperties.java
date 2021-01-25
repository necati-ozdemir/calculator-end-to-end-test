package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "calculator-service")
public class CalculatorServiceProperties {
    private String ip;
    private Integer port;
    private String additionApiPath;
    private String subtractionApiPath;
    private String additionServiceUrlEnvName;
    private String additionServiceUrlEnvValue;
    private String subtractionServiceUrlEnvName;
    private String subtractionServiceUrlEnvValue;

    public CalculatorServiceProperties() {
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

    public String getAdditionApiPath() {
        return additionApiPath;
    }

    public void setAdditionApiPath(String additionApiPath) {
        this.additionApiPath = additionApiPath;
    }

    public String getSubtractionApiPath() {
        return subtractionApiPath;
    }

    public void setSubtractionApiPath(String subtractionApiPath) {
        this.subtractionApiPath = subtractionApiPath;
    }

    public String getAdditionServiceUrlEnvName() {
        return additionServiceUrlEnvName;
    }

    public void setAdditionServiceUrlEnvName(String additionServiceUrlEnvName) {
        this.additionServiceUrlEnvName = additionServiceUrlEnvName;
    }

    public String getAdditionServiceUrlEnvValue() {
        return additionServiceUrlEnvValue;
    }

    public void setAdditionServiceUrlEnvValue(String additionServiceUrlEnvValue) {
        this.additionServiceUrlEnvValue = additionServiceUrlEnvValue;
    }

    public String getSubtractionServiceUrlEnvName() {
        return subtractionServiceUrlEnvName;
    }

    public void setSubtractionServiceUrlEnvName(String subtractionServiceUrlEnvName) {
        this.subtractionServiceUrlEnvName = subtractionServiceUrlEnvName;
    }

    public String getSubtractionServiceUrlEnvValue() {
        return subtractionServiceUrlEnvValue;
    }

    public void setSubtractionServiceUrlEnvValue(String subtractionServiceUrlEnvValue) {
        this.subtractionServiceUrlEnvValue = subtractionServiceUrlEnvValue;
    }
}
