package src;

import java.util.List;
import java.util.stream.Collectors;

public class FlowerService {
    private String filename;
    private FlowerDAO flowerDAO;
    private final String houseplant = "Кімнатна";

    public FlowerService(String filename) {
        flowerDAO = new FlowerDAO(filename);
    }

    public List<Flower> getAllFlowers() {
        return flowerDAO.getAllFlowers();
    }

    public void addFlower(Flower flower) {
        flowerDAO.addFlower(flower);
    }

    public List<Flower> getFloweringHouseplants() {
        return flowerDAO.getAllFlowers().stream()
                .filter(flower -> flower.getType().equals(houseplant) && flower.isBlooms())
                .collect(Collectors.toList());
    }

    public List<Flower> getSubtypesOfFlower(String name) {
        return flowerDAO.getAllFlowers().stream()
                .filter(flower -> flower.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public void saveData() {
        flowerDAO.saveToFile();
    }

    public void loadData() {
        flowerDAO.loadFlowers();
    }
}
