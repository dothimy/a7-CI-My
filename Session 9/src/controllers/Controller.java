package controllers;

import models.Model;
import views.View;

import java.awt.*;

/**
 * Created by mydt on 12/16/2016.
 */
public class Controller implements BaseController{
    protected Model model;
    protected View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

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

    public void run() {}
    public void draw(Graphics g) {
        view.draw(g, model);
    }

    public void destroy() {
        this.model.setAlive(false);
    }
}