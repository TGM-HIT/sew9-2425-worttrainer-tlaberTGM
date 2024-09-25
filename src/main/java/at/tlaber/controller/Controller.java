package at.tlaber.controller;

import at.tlaber.model.WordTrainer;
import at.tlaber.view.Frame;
import at.tlaber.view.Panel;

import java.awt.event.ActionEvent;
import java.io.IOException;


/**
 * Controller class
 * @author Thomas Laber
 * @version 2024-09-25
 */
public class Controller {
    private WordTrainer worttrainer;
    private Frame frame;
    private Panel panel;

    /**
     * main methode for Controller
     * @param args
     */
    public static void main(String[] args) {
        new Controller();
    }

    /**
     * Controller constructor
     */
    public Controller() {
        this.worttrainer = new WordTrainer();
        try {
            this.panel = new Panel(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.frame = new Frame(this.panel);
    }

    /**
     * getter Methode for Url
     * @return the Url of the currently displayed Word
     */
    public String getUrl() {
        return this.worttrainer.getCurrent().getUrl();
    }

    /**
     * getter Methode for correct
     * @return how many correct answers the user has given
     */
    public int getCorrect() {
        return this.worttrainer.getCorrect();
    }

    /**
     * getter methode for total
     * @return how many total answers the user has given
     */
    public int getTotal() {
        return this.worttrainer.getTotal();
    }

    /**
     * the methode which reacts to the actions the user takes in the program
     * @param action the action the user did
     */
    public void performAction(ActionEvent action) {
        String actionCommand = action.getActionCommand();
        switch (actionCommand) {
            case "input":
                if(this.worttrainer.check(this.panel.getInput())) {
                    this.worttrainer.setCorrect(getCorrect()+1);
                }
                this.worttrainer.setTotal(getTotal()+1);
                this.worttrainer.changeCurrent();
                this.panel.nextWord(this.worttrainer.getCurrent().getUrl());
                break;
            case "store":
                this.worttrainer.store();
                break;
            case "load":
                this.worttrainer.load();
                break;
            default:
                System.out.println("Unknown command: " + actionCommand);
        }
    }
}