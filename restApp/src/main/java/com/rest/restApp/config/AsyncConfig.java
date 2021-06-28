package com.rest.restApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Executor class configuration to enable multi-Threading
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    /**
     * global task executor object to run thread asynchronously
     * @return executor - type Executor
     */
    @Bean
    public Executor execute() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(50);
        executor.initialize();
        return executor;
    }
}
