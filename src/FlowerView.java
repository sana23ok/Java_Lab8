package src;
import java.io.BufferedWriter;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class FlowerView {
    private Scanner scanner;
    private Validator validator;
    private String path;

    public FlowerView() {
        scanner = new Scanner(System.in);
        validator = new Validator(scanner);
        path = getFilenameToLoad();
    }

    public void printMenu() {
        System.out.println("Flower Shop Menu:");
        System.out.println("1. View all flowers");
        System.out.println("2. Add a new flower");
        System.out.println("3. Get list of flowering houseplants and their prices");
        System.out.println("4. Get all subtypes of a specified flower and their quantities");
        System.out.println("5. Save data to file");
        System.out.println("6. Load data from file");
        System.out.println("7. Exit");
    }

    public void printInvalidChoice() {
        System.out.println("Invalid choice. Please try again.");
    }

    public void displayAllFlowers(List<Flower> flowers) {
        if (flowers.isEmpty()) {
            System.out.println("No flowers available.");
        } else {
            System.out.println("All Flowers:");
            flowers.forEach(System.out::println);
        }
    }

    public Flower getNewFlowerDetails() {
        while (true) {
            try {
                System.out.println("Enter flower details:");

                // Flower ID (positive integer)
                int id = validator.getValidIntegerInput("Flower ID (positive integer): ", true);

                // Flower name
                String name = validator.getValidStringInput("Flower name: ");

                // Flower type
                String type = validator.getValidStringInput("Flower type: ");

                // Flower kind
                String kind = validator.getValidStringInput("Flower kind: ");

                // Flower subtype (optional)
                String subtype = validator.getValidStringInput("Flower subtype (optional): ");

                // Flower price (double)
                double price = validator.getValidDoubleInput("Flower price (double): ");

                // Flower quantity (integer)
                int quantity = validator.getValidIntegerInput("Flower quantity (integer): ", false);

                // Blooms (true/false)
                boolean isBlooming = validator.getBooleanInput("Blooms (true/false): ");

                return new Flower(id, name, type, kind, subtype, price, quantity, isBlooming);

            } catch (InvalidFlowerDetailsException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println("Please try again with valid details.");
            } catch (Exception e) {
                System.err.println("An unexpected error occurred. Please enter the values in the correct format.");
                scanner.nextLine(); // Clear the invalid input from the scanner buffer
            }
        }
    }

    public void printFlowerAdded() {
        System.out.println("Flower added successfully.");
    }

    public void displayFloweringHouseplants(List<Flower> flowers) {
        if (flowers.isEmpty()) {
            System.out.println("No flowering houseplants found.");
        } else {
            System.out.println("Flowering Houseplants:");
            processResult(flowers);
        }
    }

    public String getFlowerName() {
        System.out.print("Enter flower name (example: 'flowers.csv'): ");
        return scanner.nextLine();
    }

    public void displaySubtypesOfFlower(List<Flower> flowers) {
        if (flowers.isEmpty()) {
            System.out.println("No subtypes found for the specified flower.");
        } else {
            System.out.println("Subtypes of the specified flower:");
            processResult(flowers);
        }
    }

    public String getFilenameToSave() {
        System.out.print("Enter filename to save data: ");
        return scanner.nextLine();
    }

    public String getFilenameToLoad() {
        String filename;
        do {
            System.out.print("Enter filename to load data: ");
            filename = scanner.nextLine();
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("The file does not exist. Please enter a valid filename.");
            }
        } while (!new File(filename).exists());

        return filename;
    }

    public void printDataSaved() {
        System.out.println("Data saved successfully.");
    }

    public void printDataLoaded() {
        System.out.println("Data loaded successfully.");
    }

    public String getPath() {
        return path;
    }

    public void processResult(List<Flower> flowers) {
        flowers.forEach(System.out::println);

        System.out.print("Do you want to save the results to a file? (yes/no): ");
        String response = scanner.nextLine();
        if ("yes".equalsIgnoreCase(response)) {
            String filename = getFilenameToSave();
            FlowerService fs = new FlowerService();
            fs.saveData(filename, flowers);
        }
    }
}


