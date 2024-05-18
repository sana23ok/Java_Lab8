package src;

import java.util.List;
import java.util.Scanner;

public class FlowerView {
    private Scanner scanner;
    private Validator validator;
    private String path;

    public FlowerView() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
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

                System.out.print("ID: ");
                int id = scanner.nextInt();
                validator.validateId(id);
                scanner.nextLine(); // consume newline

                System.out.print("Name: ");
                String name = scanner.nextLine();
                validator.validateNoCommas(name, "Name");

                System.out.print("Type: ");
                String type = scanner.nextLine();
                validator.validateNoCommas(type, "Type");

                System.out.print("Kind: ");
                String kind = scanner.nextLine();
                validator.validateNoCommas(kind, "Kind");

                System.out.print("Subtype: ");
                String subtype = scanner.nextLine();
                validator.validateNoCommas(subtype, "Subtype");

                System.out.print("Price: ");
                double price = scanner.nextDouble();
                validator.validatePositiveFloat(price, "Price");

                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                validator.validatePositiveInt(quantity, "Quantity");

                scanner.nextLine(); // consume newline
                System.out.print("Blooms (true/false): ");
                String bloomsInput = scanner.nextLine();
                validator.validateBoolean(bloomsInput, "Blooms");
                boolean isBlooming = Boolean.parseBoolean(bloomsInput);

                return new Flower(id, name, type, kind, subtype, price, quantity, isBlooming);
            } catch (ValidationException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please press 'Enter' to try again.");
                scanner.nextLine(); // consume any remaining input
            }
        }
        /*System.out.println("Enter flower details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        // validate ID it must me unice
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        // cant be separated by commas
        System.out.print("Type: ");
        String type = scanner.nextLine();
        // cant be separated by commas
        System.out.print("Kind: ");
        String kind = scanner.nextLine();
        // cant be separated by commas
        System.out.print("Subtype: ");
        String subtype = scanner.nextLine();
        // cant be separated by commas
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        // must be valid float
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        // must be valid int
        System.out.print("Blooms: ");
        boolean isBlooming = scanner.nextBoolean();
        // must be "true" or "false"

        // ask to enter attribute again if it is not valid

        return new Flower(id, name, type, kind, subtype, price, quantity, isBlooming);*/
    }

    public void printFlowerAdded() {
        System.out.println("Flower added successfully.");
    }

    public void displayFloweringHouseplants(List<Flower> flowers) {
        if (flowers.isEmpty()) {
            System.out.println("No flowering houseplants found.");
        } else {
            System.out.println("Flowering Houseplants:");
            flowers.forEach(System.out::println);
        }
    }

    public String getFlowerName() {
        System.out.print("Enter flower name: ");
        return scanner.nextLine();
    }

    public void displaySubtypesOfFlower(List<Flower> flowers) {
        if (flowers.isEmpty()) {
            System.out.println("No subtypes found for the specified flower.");
        } else {
            System.out.println("Subtypes of the specified flower:");
            flowers.forEach(System.out::println);
        }
    }

    public String getFilenameToSave() {
        System.out.print("Enter filename to save data: ");
        return scanner.nextLine();
    }

    public void printDataSaved() {
        System.out.println("Data saved successfully.");
    }

    public String getFilenameToLoad() {
        System.out.print("Enter filename to load data: ");
        return scanner.nextLine();
    }

    public void printDataLoaded() {
        System.out.println("Data loaded successfully.");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
