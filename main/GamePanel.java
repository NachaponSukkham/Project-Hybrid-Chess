package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

    public static final int WIDTE = 1100;
    public static final int HEIGHT = 800;

    public GamePanel() {
        setPreferredSize (new Dimension(WIDTE,HEIGHT));
        setBackground(Color.black);
    }
}