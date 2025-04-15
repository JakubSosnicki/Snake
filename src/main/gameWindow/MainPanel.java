package main.gameWindow;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Board.draw(g);
    }
}
