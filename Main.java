import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        FlowerService flowerService = new FlowerService("flowers.csv");
        FlowerView flowerView = new FlowerView();
        FlowerController controller = new FlowerController(flowerService, flowerView);
        controller.run();
    }
}
