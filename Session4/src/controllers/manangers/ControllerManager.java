package controllers.manangers;

import controllers.Controller;

import java.awt.*;
import java.util.Vector;

/**
 * Created by mydt on 12/13/2016.
 */
public class ControllerManager {
    protected Vector<Controller> controllers;
    public ControllerManager(){
        controllers=new Vector<>();
    }
    public void draw(Graphics g){
        for(Controller controller: this.controllers)
        {
            controller.draw(g);
        }
    }


    public void run(){
    for(Controller e: this.controllers){
        e.run();
    }
    }
    public void add(Controller controller){
        this.controllers.add(controller);
    }
    public void remove(Controller controller){
        this.controllers.remove(controller);
    }
}
