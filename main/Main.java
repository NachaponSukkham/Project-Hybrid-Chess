package main;
import javax.swing.*;
public class Main {
    public static void main(String[]args) {
        JFrame window = new JFrame ("Project Hybrid Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable (false);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

