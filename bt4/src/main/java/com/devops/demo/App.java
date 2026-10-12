package com.devops.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Initializing DevOps CI Demo Application...");
        CalculatorService calculator = new CalculatorService();
        int sum = calculator.add(10, 25);
        logger.info("Calculation result: 10 + 25 = {}", sum);
        logger.info("Application started successfully.");
    }
}
