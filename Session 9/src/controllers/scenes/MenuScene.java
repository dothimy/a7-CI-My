package controllers.scenes;

import java.awt.*;
import java.awt.event.KeyEvent;

import static utils.Utils.loadImage;

/**
 * Created by mydt on 12/28/2016.
 */
public class MenuScene extends GameScene{
    Image background;

    public MenuScene() {
        background = loadImage("resources/1945-logo.png");
    }

    @Override
    public void update(Graphics g) {

        g.drawImage(background, 0, 0, 800, 600, null);
        g.drawString("Menu",300,300);
    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(new PlayGameScene(), true);
    }

    @Override
    public void gameOver() {

    }
}
