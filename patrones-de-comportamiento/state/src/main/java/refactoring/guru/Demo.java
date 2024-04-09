package refactoring.guru;

import refactoring.guru.ui.Player;
import refactoring.guru.ui.UI;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}