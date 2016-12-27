package controllers;

import controllers.enemies.EnemyBulletController;
import controllers.manangers.BodyManager;
import controllers.manangers.ControllerManager;
import models.Model;
import utils.Utils;
import views.Animation;
import views.SingleView;
import views.View;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by mydt on 12/3/16.
 */
public class PlaneController extends Controller implements Body {

    private static final int SPEED = 5;

    public KeySetting keySetting;

    private ControllerManager bulletManager;

    private int Hp=5;

    public int getHp() {
        return Hp;
    }

    public static final PlaneController instance =  createPlane(300, 300);

    private PlaneController(Model model, View view) {
        super(model, view);
        bulletManager = new ControllerManager();
        BodyManager.instance.register(this);
    }

    public void keyPressed(KeyEvent e) {
        if(keySetting != null) {
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.keyUp) {
                model.move(0, -SPEED);
            } else if (keyCode == keySetting.keyDown) {
                model.move(0, SPEED);
            } else if (keyCode == keySetting.keyLeft) {
                model.move(-SPEED, 0);
            } else if (keyCode == keySetting.keyRight) {
                model.move(SPEED, 0);
            } else  if(keyCode == keySetting.keyShoot) {
                shoot();
            }
        }
    }


    @Override
    public void run() {
        super.run();
        bulletManager.run();
    }

    @Override
    public void draw(Graphics g) {
        
        if (this.model.isAlive()) {
            super.draw(g);}
//        }
        bulletManager.draw(g);

    }

    private void shoot() {
        Utils.playSound("resources/shoot.wav", false);
        BulletController bulletController = BulletController.create(this.model.getMidX() - BulletController.WIDTH/ 2,
                this.model.getY() - BulletController.HEIGHT);
        bulletManager.add(bulletController);
    }

    // Design pattern
    // Factory
    private static PlaneController createPlane(int x, int y) {
        PlaneController planeController = new PlaneController(
                new Model(x, y, 70, 50),
                new SingleView(Utils.loadImage("resources/plane3.png"))
        );
        return planeController;
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof EnemyBulletController) {
            Utils.playSound("resources/maybay.wav", false);
            this.Hp -= 1;

            this.getModel().setAlive(false);
//        if (other instanceof EnemyBulletController) {
//            System.out.println("Plane:'(");
        }
    }
    public void destroy(){

        ExplosionController explosionController=null;
        if(!this.model.isAlive()){
             explosionController=new ExplosionController(
                    new Model(this.getModel().getX(), this.getModel().getY(), 32, 32),
                    new Animation(Utils.loadSheet("resources/maybay.wav",32,32,1,6)));

        }
        ControllerManager.explosion.add(explosionController);
    }
}
