package src;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlowerView {
    private Scanner scanner;
    private Validator validator;
    private String path;
    private final Logger logger = Logger.getLogger(FlowerView.class.getName());

    public FlowerView() {
        scanner = new Scanner(System.in);
        validator = new Validator(scanner);
        path = getFilenameToLoad();

        try {
            FileHandler fh = new FileHandler("flower_shop.log");
            logger.addHandler(fh);
            logger.setLevel(Level.INFO); // Set minimum logging level (INFO)
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
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
        logger.log(Level.INFO, "User displayed menu");
    }

    public void printInvalidChoice() {
        System.out.println("Invalid choice. Please try again.");
        logger.log(Level.WARNING, "User entered invalid menu choice");
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
                int id = validator.getValidIntegerInput("Flower ID (integer): ", true);

                // Flower name
                String name = validator.getValidStringInput("Flower name: ");

                // Flower type
                String type = validator.getValidStringInput("Flower type: ");

                // Flower kind
                String kind = validator.getValidStringInput("Flower kind: ");

                // Flower subtype (optional)
                String subtype = validator.getValidStringInput("Flower subtype: ");

                // Flower price (double)
                double price = validator.getValidDoubleInput("Flower price (double): ");

                // Flower quantity (integer)
                int quantity = validator.getValidIntegerInput("Flower quantity (integer): ", false);

                // Blooms (true/false)
                boolean isBlooming = validator.getBooleanInput("Blooms (true/false): ");

                logger.log(Level.INFO, "User added flower: " + name);
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
        logger.log(Level.INFO, "User added a new flower");
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
        System.out.print("Enter flower name (example: 'Нарцис'): ");
        return scanner.nextLine();
    }

    public void displaySubtypesOfFlower(List<Flower> flowers) {
        if (flowers.isEmpty()) {
            System.out.println("No subtypes found for the specified flower.");
            logger.log(Level.WARNING, "User entered invalid input flower name!" );
        } else {
            System.out.println("Subtypes of the specified flower:");
            processResult(flowers);
        }
    }

    public String getFilenameToSave() {
        logger.log(Level.INFO, "File will be saved");
        System.out.print("Enter filename to save data (example: 'flowers.csv'): ");
        return scanner.nextLine();
    }

    public String getFilenameToLoad() {
        String filename;
        do {
            System.out.print("Enter filename to load data (example: 'flowers.csv'): ");
            filename = scanner.nextLine();
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("The file does not exist. Please enter a valid filename.");
                logger.log(Level.WARNING, "User entered invalid input for file name!" );
            }
        } while (!new File(filename).exists());
        logger.log(Level.INFO, "File "+filename+" will be loaded");
        return filename;
    }

    public void printDataSaved() {
        System.out.println("Data saved successfully.");
        logger.log(Level.INFO, "User saved data to file");
    }

    public void printDataLoaded() {
        System.out.println("Data loaded successfully.");
        logger.log(Level.INFO, "User loaded data from file");
    }

    public String getPath() {
        return path;
    }

    public void processResult(List<Flower> flowers) {
        logger.log(Level.INFO, "Processing flower list");
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


