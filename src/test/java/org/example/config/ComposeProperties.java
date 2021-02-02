package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "compose")
public class ComposeProperties {

    private static final String DEFAULT_WORKER_IP = "localhost";
    private static final String DEFAULT_PATH = "default/path/docker-compose.yml";

    private String path = DEFAULT_PATH;
    private String workerIp = DEFAULT_WORKER_IP;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getWorkerIp() {
        return workerIp;
    }

    public void setWorkerIp(String workerIp) {
        this.workerIp = workerIp;
    }
}
