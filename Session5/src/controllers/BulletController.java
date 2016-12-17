package controllers;

import controllers.manangers.BodyManager;
import models.Model;
import utils.Utils;
import views.View;

import java.awt.*;

/**
 * Created by mydt on 12/6/2016.
 */
public class BulletController extends Controller implements Body {

    public BulletController(Model model, View view) {
        super(model, view);
            BodyManager.instance.register(this);
    }

    public void run() {
        this.model.move(0, -5);
    }

    public static BulletController createBullet(int x, int y) {
        return new BulletController(new Model(x, y, 13, 32),
                new View(Utils.loadImage("resources/bullet.png")));

    }

    @Override
    public void onContact(Body other) {
        if(other instanceof EnemyController){
        System.out.println("hihi");
            this.model.setAlive(false);
    }
}}
