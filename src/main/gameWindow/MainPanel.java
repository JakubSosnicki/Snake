package main.gameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {

    private Snake snake = new Snake();
    private boolean gameOver = false; //collision result variable

    public MainPanel() {
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
        MainTimer timer = new MainTimer();
        timer.start();

        setFocusable(true); // setting focus
        addKeyListener(new MyKeyAdapter()); // listener for keyboard action

        MainFrame.score.setText("Score: " + snake.getSize());  //start text for score label
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
                if (!gameOver) {  //execute code when game is not over
                    snake.move();
                    if (snake.isCollision()) {
                        gameOver = true;        //collision check
                        MainFrame.score.setText("GAME OVER - Score: " + snake.getSize()); //set score text if game over
                    }
                    repaint(); // refresh window after snake moving
                }
            });
        }
    }

    private class MyKeyAdapter extends KeyAdapter {
        /**
        Class handling moving event,
         It's to ways to move snake: arrows or WSAD
         It's forbidden to move 180 degrees
         */
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (snake.getDirection() != Direction.R) {
                        snake.setDirection(Direction.L);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (snake.getDirection() != Direction.L) {
                        snake.setDirection(Direction.R);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (snake.getDirection() != Direction.U) {
                        snake.setDirection(Direction.D);
                    }
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (snake.getDirection() != Direction.D) {
                        snake.setDirection(Direction.U);
                    }
                    break;

            }
        }
    }
}
