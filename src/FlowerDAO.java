package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlowerDAO {
    private List<Flower> flowers;
    private String path;

    public FlowerDAO(String path) {
        flowers = new ArrayList<>();
        this.path = path;
//        loadFlowers(path);
    }

    public FlowerDAO() {
        flowers = new ArrayList<>();
    }

    private Flower parseFlowerFromCSV(String csvLine) {
        String[] values = csvLine.split(",");

        int id = Integer.parseInt(values[0].trim());
        String name = values[1].trim();
        String type = values[2].trim();
        String species = values[3].trim();
        String subspecies = values[4].trim();
        double price = Double.parseDouble(values[5].trim());
        int quantity = Integer.parseInt(values[6].trim());
        boolean blooms = Boolean.parseBoolean(values[7].trim());

        return new Flower(id, name, type, species, subspecies, price, quantity, blooms);
    }

    void loadFlowers(String path) {
        flowers.clear(); // Clear the existing list before loading new data
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Пропускаємо заголовок CSV
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Flower flower = parseFlowerFromCSV(line);
                flowers.add(flower);
            }
        } catch (IOException e) {
            throw new RuntimeException("File is not found!");
        }
    }

    public List<Flower> getAllFlowers() {
        return new ArrayList<>(flowers);
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    // Метод для збереження даних у файл
    public void saveToFile(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            // Write header row
            bw.write("ID,Name,Type,Species,Subspecies,Price,Quantity,Blooms\n");

            // Write each flower data
            for (Flower flower : flowers) {
                String flowerData = String.format("%d,%s,%s,%s,%s,%f,%d,%s\n",
                        flower.getID(), flower.getName(), flower.getType(), flower.getSpecies(),
                        flower.getSubspecies(), flower.getPrice(), flower.getQuantity(), flower.isBlooms());
                bw.write(flowerData);
            }
            bw.flush(); // Ensures data is written to the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to save data to a file
    public void saveToFile(List<Flower> flowers, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            // Write header row
            bw.write("ID,Name,Type,Species,Subspecies,Price,Quantity,Blooms\n");

            // Write each flower data
            for (Flower flower : flowers) {
                String flowerData = String.format("%d,%s,%s,%s,%s,%.2f,%d,%s\n",
                        flower.getID(), flower.getName(), flower.getType(), flower.getSpecies(),
                        flower.getSubspecies(), flower.getPrice(), flower.getQuantity(), flower.isBlooms());
                bw.write(flowerData);
            }
            bw.flush(); // Ensures data is written to the file
            System.out.println("Data saved to file: " + filename);
        } catch (IOException e) {
            throw new RuntimeException("Error saving data to file: " + filename, e);
        }
    }

}

