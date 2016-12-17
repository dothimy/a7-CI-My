package controllers;

import controllers.manangers.BodyManager;
import models.Model;
import utils.Utils;
import views.View;

import java.util.Vector;

/**
 * Created by mydt on 12/12/2016.
 */
public class BulletEnemyController extends Controller implements Body{
    private static final int SPEED = 7;
    public static final int WIDTH =10 ;
    public static final int HEIGHT =10 ;

    public BulletEnemyController(Model model, View view) {

        super(model, view);
        BodyManager.instance.register(this);
    }

    @Override
    public void run() {

        model.move(0, SPEED);
    }

    public static BulletEnemyController createBulletEnemy(int x, int y){
        return  new BulletEnemyController(
                new Model(x,y,WIDTH, HEIGHT),
                new View(Utils.loadImage("resources/bullet-round.png"))
        );
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneController){
        System.out.println("enemy");
            this.model.setAlive(false);
    }}
}
