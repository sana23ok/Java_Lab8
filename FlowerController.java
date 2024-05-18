import java.util.List;
import java.util.Scanner;

public class FlowerController {
    private FlowerService flowerService;
    private FlowerView flowerView;
    private Scanner scanner;

    public FlowerController(FlowerService flowerService, FlowerView flowerView) {
        this.flowerService = flowerService;
        this.flowerView = flowerView;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            flowerView.printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayAllFlowers();
                    break;
                case 2:
                    addNewFlower();
                    break;
                case 3:
                    displayFloweringHouseplants();
                    break;
                case 4:
                    displaySubtypesOfFlower();
                    break;
                case 5:
                    saveData();
                    break;
                case 6:
                    loadData();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    flowerView.printInvalidChoice();
            }
        }
    }

    private void displayAllFlowers() {
        List<Flower> flowers = flowerService.getAllFlowers();
        flowerView.displayAllFlowers(flowers);
    }

    private void addNewFlower() {
        Flower flower = flowerView.getNewFlowerDetails();
        flowerService.addFlower(flower);
        flowerView.printFlowerAdded();
    }

    private void displayFloweringHouseplants() {
        List<Flower> flowers = flowerService.getFloweringHouseplants();
        flowerView.displayFloweringHouseplants(flowers);
    }

    private void displaySubtypesOfFlower() {
        String name = flowerView.getFlowerName();
        List<Flower> flowers = flowerService.getSubtypesOfFlower(name);
        flowerView.displaySubtypesOfFlower(flowers);
    }

    private void saveData() {
//        String filename = flowerView.getFilenameToSave();
        flowerService.saveData();
        flowerView.printDataSaved();
    }

    private void loadData() {
//        String filename = flowerView.getFilenameToLoad();
        flowerService.loadData();
        flowerView.printDataLoaded();
    }
}
