package com.example.exception_ex.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@EnableScheduling
@EnableAsync
public class SchedulingConfig {
    private final Logger logger = LoggerFactory.getLogger(SchedulingConfig.class);

    @Scheduled(fixedRate = 2000)
    @Async
    public void printTimeInLog() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("The current time is {}", LocalTime.now());
    }

}
