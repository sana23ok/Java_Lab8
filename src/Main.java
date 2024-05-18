package src;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        FlowerView flowerView = new FlowerView();
        FlowerService flowerService = new FlowerService(flowerView.getPath());
        FlowerController controller = new FlowerController(flowerService, flowerView);
        controller.run();
    }
}
