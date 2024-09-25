package at.tlaber.controller;

import at.tlaber.model.WordTrainer;
import at.tlaber.view.Frame;
import at.tlaber.view.Panel;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class Controller {
    private WordTrainer worttrainer;
    private Frame frame;
    private Panel panel;

    public static void main(String[] args) {
        new Controller();
    }

    public Controller() {
        this.worttrainer = new WordTrainer();
        try {
            this.panel = new Panel(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.frame = new Frame(this.panel);
    }

    public String getUrl() {
        return this.worttrainer.getCurrent().getUrl();
    }

    public int getCorrect() {
        return this.worttrainer.getCorrect();
    }

    public int getTotal() {
        return this.worttrainer.getTotal();
    }

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