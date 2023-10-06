package com.memory.clientsdk;

import com.memory.clientsdk.client.MemoryClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("memory-api.client")
@Data
@ComponentScan
class MemoryClientConfig {
    private String access_key;
    private String secret_key;

    @Bean
    public MemoryClient memoryClient(){
//        return new MemoryClient(access_key,secret_key);
        return new MemoryClient();
    }
}
