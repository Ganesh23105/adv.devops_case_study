package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Hello World! ganesh");
        performCalculation();
    }

    private static void performCalculation() {
        Scanner scanner = new Scanner(System.in);
        logger.debug("Waiting for user input...");
        logger.info("Enter two numbers to divide:");

        try {
            logger.info("Requesting numerator input.");
            logger.info("Enter numerator: ");
            int numerator = Integer.parseInt(scanner.nextLine());

            logger.info("Requesting denominator input.");
            logger.info("Enter denominator: ");
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

    private static int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        return numerator / denominator;
    }
}
