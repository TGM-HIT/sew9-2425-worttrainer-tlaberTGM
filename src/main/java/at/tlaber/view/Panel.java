package at.tlaber.view;

import at.tlaber.controller.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Panel class
 * @author Thomas Laber
 * @version 2024-09-25
 */
public class Panel extends JPanel {
    private Controller controller;
    private JLabel correct, total, picture;
    private String url;
    private JTextField input;
    private JButton load, store;

    /**
     * constructor for Panel
     * @param controller the controller which is used for the panel
     * @throws URISyntaxException if URI is used
     * @throws MalformedURLException if URL is used
     */
    public Panel(Controller controller) throws URISyntaxException, MalformedURLException {
        this.setLayout(new BorderLayout()); //setting general layout
        this.controller = controller;
        this.url = controller.getUrl();

        //TOP
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1,1));
        JLabel question = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)?");
        question.setHorizontalAlignment(JLabel.CENTER);
        top.add(question);
        this.add(top, BorderLayout.PAGE_START);

        //Image - CENTER
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,1));
        ImageIcon icon = new ImageIcon(new URL(this.url));
        Image image = icon.getImage();
        image = image.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        this.picture = new JLabel(new ImageIcon(image));
        center.add(picture);
        this.add(center, BorderLayout.CENTER);


        //Textinput,Buttons & Stats - BOTTOM
        //General
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(3,1));
        bottom.setBorder(new EmptyBorder(0,20,20,20));

        //Textinput
        this.input = new JTextField();
        bottom.add(input);

        //Buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1,2));
        this.store = new JButton("Store");
        this.load = new JButton("Load");
        buttons.add(store);
        buttons.add(load);
        bottom.add(buttons);

        //Stats, wo angezeigt wird, wie viele Antworten richtig und falsch sind
        JPanel stats = new JPanel();
        stats.setLayout(new GridLayout(2,2));
        JLabel textC = new JLabel("Richtige Wörter:");
        JLabel textT = new JLabel("Gesamtanzahl:");
        this.correct = new JLabel(String.valueOf(this.controller.getCorrect()));
        this.total = new JLabel(String.valueOf(this.controller.getTotal()));
        stats.add(textC);
        stats.add(textT);
        stats.add(correct);
        stats.add(total);
        bottom.add(stats);

        this.add(bottom, BorderLayout.PAGE_END);

        //ActionListener
        this.input.addActionListener(this.controller);
        this.input.setActionCommand("input");

        this.store.addActionListener(this.controller);
        this.store.setActionCommand("store");

        this.load.addActionListener(this.controller);
        this.load.setActionCommand("load");
    }

    /**
     * getter for input
     * @return the input the user wrote
     */
    public String getInput() {
        return this.input.getText();
    }

    /**
     * method for switching to the next picture
     * @param url the url for the next picture
     */
    public void next(String url) {
        this.input.setText("");
        this.correct.setText(String.valueOf(this.controller.getCorrect()));
        this.total.setText(String.valueOf(this.controller.getTotal()));
        this.url = url;
        try {
            reload();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * methode to reload the frame
     * @throws IOException if URL is used
     * @throws URISyntaxException if URI is used
     */
    public void reload() throws IOException, URISyntaxException {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,1));
        ImageIcon icon = new ImageIcon(new URL(this.url));
        Image image = icon.getImage();
        image = image.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        this.picture = new JLabel(new ImageIcon(image));
        center.add(picture);
        this.add(center, BorderLayout.CENTER);
    }
}
