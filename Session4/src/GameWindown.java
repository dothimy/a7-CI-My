import controllers.*;
//import controllers.manangers.EnemyControllermananger;
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
    EnemyControllermanager enemyControllermanager;

    BulletController bulletController;
    Vector<BulletController> bulletControllerVector;
    ControllerManager controllerManager;
    Vector<BulletEnemyController> bulletEnemyControllerVector;
    private int timerCouter;
    public GameWindown() {
        //this.enemyController= EnemyController .createEnemy(500,0);
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
       // Model enemyModel=new Model(200,200,50,70);
       // Model bulletEnemyModel =new Model(enemyModel.getX()+70-6,enemyModel.getY()-30,13,33);
        View enemyView=new View(loadImage("resources/enemy_plane_white_1.png"));
         View planeView=new View(loadImage("resources/plane3.png"));
        planeController =PlaneController.createPlane(300,500);

       // bulletEnemyControllerVector.add(BulletEnemyController.createBulletEnemy(enemyModel.getX(),enemyModel.getY()));
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
                        // ban lien tuc xem size max no dat dc la bao nhieu
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
