package controllers;

import models.Model;
import utils.Utils;
import views.View;

import java.awt.*;
import java.util.Vector;

/**
 * Created by mydt on 12/12/2016.
 */
public class EnemyController extends Controller {
    private static final int SPEED =1 ;
    public static final int WIDTH = 70;
    private static final int HIEGHT =50 ;
    public int timeCounter;
    private Vector<BulletEnemyController> bulletEnemyControllers;

    public EnemyController(Model model, View view) {
        super(model, view);
        bulletEnemyControllers=new Vector<>();
        timeCounter=0;
    }

    @Override
    public void run() {
        timeCounter++;
        if(timeCounter>30){
            shoot();
            timeCounter=0;
        }
        this.model.move(-SPEED,SPEED);

        for(BulletEnemyController bulletEnemyController: this.bulletEnemyControllers)
            bulletEnemyController.run();
    }


    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (BulletEnemyController bulletEnemyController: this.bulletEnemyControllers){
            bulletEnemyController.draw(g);
        }
    }

    private void shoot() {
        BulletEnemyController bulletEnemyController = BulletEnemyController.createBulletEnemy(
                this.model.getMidX()-BulletEnemyController.WIDTH/2,
                this.model.getBottom()
        );
        this.bulletEnemyControllers.add(bulletEnemyController);

    }

    public static  EnemyController createEnemy(int x, int y){
        return new EnemyController(
                new Model(x,y,WIDTH,HIEGHT),
        new View(Utils.loadImage("resources/enemy_plane_white_3.png")));
    }
}
