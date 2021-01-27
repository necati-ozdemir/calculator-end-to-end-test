package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "calculator-service")
public class CalculatorServiceProperties {

    private static final String DEFAULT_IP = "localhost";
    private static final Integer DEFAULT_PORT = 8080;
    private static final String DEFAULT_IMAGE_NAME = "default/image-name:latest";
    private static final String DEFAULT_ADDITION_API_PATH = "/default/addition/api/path";
    private static final String DEFAULT_SUBTRACTION_API_PATH = "/default/subtraction/api/path";
    private static final String DEFAULT_ADDITION_SERVICE_URL_ENV_NAME = "DEFAULT_ADDITION_SERVICE_URL_ENV_NAME";
    private static final String DEFAULT_ADDITION_SERVICE_URL_ENV_VALUE = "http://addition-ip:8080/default/api/path";
    private static final String DEFAULT_SUBTRACTION_SERVICE_URL_ENV_NAME = "DEFAULT_SUBTRACTION_SERVICE_URL_ENV_NAME";
    private static final String DEFAULT_SUBTRACTION_SERVICE_URL_ENV_VALUE = "http://subtraction-ip:8080/default/api/path";

    private String ip = DEFAULT_IP;
    private Integer port = DEFAULT_PORT;
    private String imageName = DEFAULT_IMAGE_NAME;
    private String additionApiPath = DEFAULT_ADDITION_API_PATH;
    private String subtractionApiPath = DEFAULT_SUBTRACTION_API_PATH;
    private String additionServiceUrlEnvName = DEFAULT_ADDITION_SERVICE_URL_ENV_NAME;
    private String additionServiceUrlEnvValue = DEFAULT_ADDITION_SERVICE_URL_ENV_VALUE;
    private String subtractionServiceUrlEnvName = DEFAULT_SUBTRACTION_SERVICE_URL_ENV_NAME;
    private String subtractionServiceUrlEnvValue = DEFAULT_SUBTRACTION_SERVICE_URL_ENV_VALUE;

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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
