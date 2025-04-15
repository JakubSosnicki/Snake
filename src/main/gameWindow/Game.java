package main.gameWindow;

import java.awt.*;

public class Game {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(); // create frame
            mainFrame.setVisible(true); //set visible
        });
    }
}
