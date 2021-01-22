package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "calculator-test")
public class CalculatorTestProperties {
    private static final String DEFAULT_WORKER_IP = "localhost";

    private String workerIp = DEFAULT_WORKER_IP;

    public String getWorkerIp() {
        return workerIp;
    }

    public void setWorkerIp(String workerIp) {
        this.workerIp = workerIp;
    }
}
