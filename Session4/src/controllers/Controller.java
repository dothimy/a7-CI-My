package controllers;

import models.Model;
import views.View;

import java.awt.*;

/**
 * Created by mydt on 12/7/2016.
 */
public class Controller {
    protected Model model;
    protected View view;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void run(){
    }

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void draw(Graphics g){
        view.draw(g,model);
    }

    public void run1() {
    }
}
