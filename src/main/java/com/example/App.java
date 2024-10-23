package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Application Started");
        try {
            performCalculation();
        } catch (Exception e) {
            logger.error("An error occurred: {}", e.getMessage());
        }
        logger.info("Application Finished");
    }

    private static void performCalculation() {
        Scanner scanner = new Scanner(System.in);
        logger.debug("Waiting for user input...");
        logger.info("Enter two numbers to divide:");
    
        try {
            logger.info("Requesting numerator input.");
            System.out.print("Enter numerator: ");
            int numerator = Integer.parseInt(scanner.nextLine());
    
            logger.info("Requesting denominator input.");
            System.out.print("Enter denominator: ");
            int denominator = Integer.parseInt(scanner.nextLine());
    
            int result = divide(numerator, denominator);
            logger.info("Result of division: {}", result);
        } catch (NumberFormatException e) {
            logger.warn("Invalid input: {}", e.getMessage());
        } catch (ArithmeticException e) {
            logger.error("Division error: {}", e.getMessage());
        } finally {
            scanner.close();
            logger.debug("Scanner closed");
        }
    }
    
}

