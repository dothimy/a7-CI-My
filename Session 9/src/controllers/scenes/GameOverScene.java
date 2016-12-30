package controllers.scenes;

import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by mydt on 12/30/2016.
 */
public class GameOverScene extends GameScene {

    @Override
    public void update(Graphics g) {

        g.drawImage(Utils.loadImage("resources/1945-logo.png"),0,0,800,600,null);
        g.drawString("OVer",300,300);
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(new MenuScene(),false);
    }

    @Override
    public void gameOver() {

    }

}
