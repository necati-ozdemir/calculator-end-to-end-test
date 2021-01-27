package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "addition-service")
public class AdditionServiceProperties {

    private static final String DEFAULT_IP = "localhost";
    private static final Integer DEFAULT_PORT = 8080;
    private static final String DEFAULT_API_PATH = "/default/api/path";
    private static final String DEFAULT_IMAGE_NAME = "default/image-name:latest";

    private String ip = DEFAULT_IP;
    private Integer port = DEFAULT_PORT;
    private String apiPath = DEFAULT_API_PATH;
    private String imageName = DEFAULT_IMAGE_NAME;

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

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
