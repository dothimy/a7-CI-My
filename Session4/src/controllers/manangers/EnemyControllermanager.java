package controllers.manangers;

import controllers.EnemyController;

import java.awt.*;
import java.util.Vector;

/**
 * Created by mydt on 12/13/2016.
 */
public class EnemyControllermanager extends ControllerManager{
    private Vector<EnemyControllermanager> enemyControllermanager;

        public int timeCounter=0;
    public void run() {
            super.run();
        timeCounter++;
        if (timeCounter > 30) {
            spawn();
            timeCounter = 0;
        }
    }

    private void spawn() {
        EnemyController enemyController = EnemyController.createEnemy(600, 0);

        this.controllers.add(enemyController);

    }
}