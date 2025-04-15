package main.gameWindow;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");
        add(new MainPanel());
        pack(); // adjusts the appropriate minimum size
        setLocationRelativeTo(null); // frame in the screen center
        setResizable(false); // size cannot be change
    }


}
