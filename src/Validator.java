package src;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;



class InvalidFlowerDetailsException extends InputMismatchException  {
    public InvalidFlowerDetailsException(String message) {
        super(message);
    }
}


public class Validator {

    private Scanner scanner;

    public Validator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getValidIntegerInput(String prompt, boolean positiveOnly) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                if (positiveOnly && input <= 0) {
                    throw new InvalidFlowerDetailsException("The ID must be a positive integer.");
                }
                return input;
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the invalid input from the scanner buffer
            }
        }
    }

    public double getValidDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double input = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                return input;
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a double value (e.g., 12,34).");
                scanner.nextLine(); // Clear the invalid input from the scanner buffer
            }
        }
    }

    public String getValidStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public boolean getBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
        }
    }
}

