package main.gameWindow;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static  JLabel score;    // score label

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");

        score = new JLabel("Score: ", SwingConstants.CENTER); //setting text and position

        add(new MainPanel());
        pack(); // adjusts the appropriate minimum size
        add(score, BorderLayout.NORTH); // set score label to the north - under the game frame
        score.setFont(new Font(score.getFont().getName(), Font.BOLD,30)); //set font parameters for score label
        setLocationRelativeTo(null); // frame in the screen center
        setResizable(false); // size cannot be change
    }


}
