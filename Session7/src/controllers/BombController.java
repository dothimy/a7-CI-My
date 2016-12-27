package controllers;

import controllers.enemies.EnemyController;
import controllers.manangers.BodyManager;
import models.Model;
import utils.Utils;
import views.SingleView;
import views.View;

import java.awt.*;

/**
 * Created by mydt on 12/27/2016.
 */
public class BombController extends Controller implements Body {
    public BombController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }
    public static BombController creadedBomb(int x, int y){
        BombController bombController=new BombController(
                new Model(x,y,30,30),
                new SingleView(Utils.loadImage("resources/bomb.png"))
        );
        return bombController;
    }

    @Override
    public void run() {
        this.model.move(0,2);
    }
    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneController){
            this.model.setAlive(false);
            System.out.println("â");
            for (int i=0; i<BodyManager.instance.getBodies().size();i++){
                if(BodyManager.instance.getBodies().get(i) instanceof EnemyController){
                    int x= model.getMidX()-other.getModel().getMidX();
                    int y=model.getMidY()-other.getModel().getMidY();
                    double r=Math.sqrt(x*x+y*y);
                    if(r<200){
                        System.out.println("Vòa");
                        BodyManager.instance.getBodies().get(i).getModel().setAlive(false);
                    }
                }
            }
        }

    }


}