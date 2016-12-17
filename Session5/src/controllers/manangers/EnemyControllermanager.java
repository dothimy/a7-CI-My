package controllers.manangers;

import controllers.EnemyController;

import java.awt.*;
import java.util.Vector;

/**
 * Created by mydt on 12/13/2016.
 */
public class EnemyControllermanager extends ControllerManager {


    public int timeCounter = 0;

    public void run() {
        super.run();
        timeCounter++;
        if (timeCounter > 30) {
            spawn();
            timeCounter = 0;
        }
    }

    private void spawn() {
        EnemyController enemyController = EnemyController.createEnemy(500, 50);// tao ra may bay o 600 0 ak

        this.controllers.add(enemyController);

    }
}