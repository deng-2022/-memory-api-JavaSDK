package com.memory.client;

import com.memory.client.properties.MemoryClientProperties;
import com.memory.client.service.MemoryClientService;
import com.memory.client.service.impl.MemoryClientServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(MemoryClientService.class)
@EnableConfigurationProperties(MemoryClientProperties.class)
class MemoryClientAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MemoryClientService memoryClientService() {
        return new MemoryClientServiceImpl();
    }
}
