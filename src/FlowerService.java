package src;
import java.util.List;
import java.util.stream.Collectors;

public class FlowerService {
    //private String filename;
    private FlowerDAO flowerDAO;
    private final String houseplant = "Кімнатна";

    public FlowerService(String path) {
        flowerDAO = new FlowerDAO(path);
        loadData(path);
    }

    public FlowerService() {
        flowerDAO = new FlowerDAO();
    }

    public List<Flower> getAllFlowers() {
        return flowerDAO.getAllFlowers();
    }

    public void addFlower(Flower flower) {
        List<Flower> flowers = flowerDAO.getAllFlowers();

        boolean isDuplicate = flowers.stream().anyMatch(f -> f.getID() == flower.getID());

        if (!isDuplicate) {
            flowerDAO.addFlower(flower);
            System.out.println("Flower added successfully.");
        } else {
            System.out.println("Error: A flower with the same ID already exists.");
        }

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

    public void saveData(String fn) {
        flowerDAO.saveToFile(fn);
    }

    public void saveData(String fn, List<Flower> flowers) {
        flowerDAO.saveToFile(flowers, fn);
    }

    public void loadData(String fn) {
        flowerDAO.loadFlowers(fn);
    }
}
