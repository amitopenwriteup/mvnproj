package com.handson.training.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingJavaApp {
    private static final Logger logger = LoggerFactory.getLogger(TrainingJavaApp.class);

    public static void main(String[] args) {
        logger.info("Starting Demo Training JavaBasedApp ");
        SpringApplication.run(TrainingJavaApp.class, args);
    }
}
