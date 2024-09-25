package at.tlaber.view;

import javax.swing.*;

/**
 * Frame class
 * @author Thomas Laber
 * @version 2024-09-25
 */
public class Frame extends JFrame {

    /**
     * constructor for Frame class
     * @param panel the panel which will be in the frame
     */
    public Frame(JPanel panel) {
        super("Worttrainer von Thomas Laber 5AHIT");
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
