package com.memory.client.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 邓哈哈
 * 2024/1/8 11:04
 * Function:
 * Version 1.0
 */

@ConfigurationProperties(prefix = "memory.client")
public class MemoryClientProperties {
    private String accessKey;
    private String secretKey;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
