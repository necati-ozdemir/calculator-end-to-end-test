package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "compose")
public class ComposeProperties {

    private static final String DEFAULT_WORKER_IP = "localhost";
    private static final String DEFAULT_CALCULATOR_PATH = "default/path/docker-compose.yml";
    private static final String DEFAULT_SELENIUM_GRID_PATH = "default/path/selenium/docker-compose.yml";

    private String calculatorPath = DEFAULT_CALCULATOR_PATH;
    private String seleniumGridPath = DEFAULT_SELENIUM_GRID_PATH;
    private String workerIp = DEFAULT_WORKER_IP;

    public String getSeleniumGridPath() {
        return seleniumGridPath;
    }

    public void setSeleniumGridPath(String seleniumGridPath) {
        this.seleniumGridPath = seleniumGridPath;
    }

    public String getCalculatorPath() {
        return calculatorPath;
    }

    public void setCalculatorPath(String calculatorPath) {
        this.calculatorPath = calculatorPath;
    }

    public String getWorkerIp() {
        return workerIp;
    }

    public void setWorkerIp(String workerIp) {
        this.workerIp = workerIp;
    }
}
