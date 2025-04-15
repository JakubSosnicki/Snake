package main.gameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private Snake snake = new Snake();

    public MainPanel() {
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
        MainTimer timer = new MainTimer();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Board.draw(g);
        snake.draw(g);
    }

    private class MainTimer extends Timer {
        public static final int DELAY = 100;

        public MainTimer() {
            super(DELAY, e -> {
                snake.move();
                repaint(); // refresh window after snake moving
            });
        }
    }
}
