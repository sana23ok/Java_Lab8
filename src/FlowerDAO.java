package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlowerDAO {
    private List<Flower> flowers;
    private String path;

    public FlowerDAO(String path) {
        this.path = path;
        flowers = new ArrayList<>();
        loadFlowers();
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

    void loadFlowers() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Пропускаємо заголовок CSV
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Flower flower = parseFlowerFromCSV(line);
                flowers.add(flower);
                //System.out.println(flower);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Flower> getAllFlowers() {
        return new ArrayList<>(flowers);
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    // Метод для збереження даних у файл
    public void saveToFile() {
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

    /* public void saveToFile(String... filePath) {
        String savePath = filePath.length > 0 ? filePath[0] : this.path;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(savePath))) {
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
  */
}

