import controllers.*;
//import controllers.manangers.EnemyControllermananger;
import controllers.manangers.BodyManager;
import controllers.manangers.ControllerManager;
import controllers.manangers.EnemyControllermanager;
import models.Model;
import views.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by mydt on 12/6/2016.
 */
public class GameWindown extends Frame implements Runnable{

    Image background;
    BufferedImage bufferedImage;
    PlaneController planeController;
    EnemyControllermanager  enemyControllermanager;

    BulletController bulletController;
    Vector<BulletController> bulletControllerVector;
    ControllerManager controllerManager;
    Vector<BulletEnemyController> bulletEnemyControllerVector;
    public GameWindown() {

        enemyControllermanager= new EnemyControllermanager();

        bulletControllerVector= new Vector<>();
        controllerManager=new ControllerManager();
        bulletEnemyControllerVector= new Vector<>();
        for (int i = 0; i < bulletControllerVector.size(); i++) {
            bulletControllerVector.get(i).getModel().move(0, -5);
        }

        for (int i = 0; i < bulletEnemyControllerVector.size(); i++) {
            bulletEnemyControllerVector.get(i).getModel().move(0, 2);
        }
        setVisible(true);
        setSize(800, 600);
        Model planeModel= new Model(300,500,50,70);

        View enemyView=new View(loadImage("resources/enemy_plane_white_1.png"));
         View planeView=new View(loadImage("resources/plane3.png"));
        planeController =PlaneController.createPlane(300,500);


        bufferedImage =new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        planeController.setKeySetting(keySetting);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                planeController.KeyPressed(e);
             if(e.getKeyCode()==KeyEvent.VK_SPACE){
                  bulletControllerVector.add(BulletController.createBullet(planeController.getModel().getX()+35-6,
                          planeController.getModel().getY()-30));

            }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        background = loadImage("resources/background.png");

    }


    //factory
    //design pattern

    @Override
    public void update(Graphics g) {

        Graphics backBufferGraphic = bufferedImage.getGraphics();
        backBufferGraphic.drawImage(background, 0, 0, 800, 600, null);
        planeController.draw(backBufferGraphic);
        enemyControllermanager.draw(backBufferGraphic);
        System.out.println("Vẽ máy bay");
        controllerManager.draw(backBufferGraphic);

        if(bulletControllerVector.size()!=0){
            for (int i = 0; i < bulletControllerVector.size(); i++) {
                bulletControllerVector.get(i).draw(backBufferGraphic);
            }}
        if (bulletEnemyControllerVector.size() != 0) {
            for (int i = 0; i < bulletEnemyControllerVector.size(); i++) {
                bulletEnemyControllerVector.get(i).draw(backBufferGraphic);
            }
        }
            g.drawImage(bufferedImage, 0, 0, 800, 600, null);
        }


    @Override
    public void run() {
        while(true) {
            try {
                this.repaint();
                Thread.sleep(17);
                enemyControllermanager.run();
                BodyManager.instance.checkContact();
                for (int i = 0; i < bulletControllerVector.size(); i++) {
                    bulletControllerVector.get(i).getModel().move(0, -5);
                }
                for (int i = 0; i < bulletEnemyControllerVector.size(); i++) {
                    bulletEnemyControllerVector.get(i).getModel().move(0, 2);
                }
                for (int i = 0; i < bulletControllerVector.size(); i++) {

                    if (bulletControllerVector.get(i).getModel().getY() < 0) {
                        bulletControllerVector.remove(i);
                        System.out.println("so dan : " + bulletControllerVector.size());

                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
