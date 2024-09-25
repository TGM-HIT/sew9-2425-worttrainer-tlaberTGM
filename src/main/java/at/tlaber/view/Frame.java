package at.tlaber.view;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame(JPanel panel) {
        super("Worttrainer von Thomas Laber 5AHIT");
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
