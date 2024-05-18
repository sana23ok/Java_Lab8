package src;

import java.util.List;
import java.util.Scanner;

public class FlowerView {
    private Scanner scanner;

    public FlowerView() {
        this.scanner = new Scanner(System.in);
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
        System.out.println("Enter flower details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Kind: ");
        String kind = scanner.nextLine();
        System.out.print("Subtype: ");
        String subtype = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Blooms: ");
        boolean isBlooming = scanner.nextBoolean();

        return new Flower(id, name, type, kind, subtype, price, quantity, isBlooming);
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
}
