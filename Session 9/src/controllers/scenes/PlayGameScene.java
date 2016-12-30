package controllers.scenes;

import controllers.BaseController;
import controllers.GameSetting;
import controllers.PlaneController;
import controllers.managers.BodyManager;
import controllers.managers.ControllerManager;
import controllers.managers.EnemyControllerManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by mydt on 12/28/2016.
 */
public class PlayGameScene extends GameScene{
    Image background;

    Vector<BaseController> controllers;

    public PlayGameScene() {
        controllers = new Vector<>();
        controllers = new Vector<>();
        controllers.add(new EnemyControllerManager());
        controllers.add(ControllerManager.explosion);
        controllers.add(PlaneController.instance);
        controllers.add(BodyManager.instance);
        controllers.add(ControllerManager.enemyBullet);
        controllers.add(ControllerManager.bomb);

        background = loadImage("resources/background.png");
    }
    @Override
    public void update(Graphics g) {
        g.drawImage(background, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
        for(BaseController baseController : this.controllers) {
            baseController.draw(g);
        }
    }

    @Override
    public void run() {
        for (BaseController controller : controllers) {
            controller.run();
        }
        if(PlaneController.instance.getHp()<=0){
            gameOver();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        PlaneController.instance.keyPressed(e);
    }

    @Override
    public void gameOver() {
        this.sceneListener.replaceScene(new GameOverScene(),false);
    }
}
