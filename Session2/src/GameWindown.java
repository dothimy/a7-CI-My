import controllers.BulletController;
import controllers.KeySetting;
import controllers.PlaneController;
import models.BulletModel;
import models.PlaneModel;
import views.BulletView;
import views.PlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by mydt on 12/6/2016.
 */
public class GameWindown extends Frame implements Runnable{

    Image background;
    BufferedImage bufferedImage;
    PlaneController planeController;

    PlaneModel planeModel;
    PlaneView planeView;
    BulletController bulletController;
    BulletModel bulletModel;
    BulletView bulletView;
    Vector<BulletController> bulletControllerVector;
    public GameWindown() {
        bulletControllerVector= new Vector<>();
        setVisible(true);
        setSize(800, 600);
        planeModel= new PlaneModel(300,300);

        planeView=new PlaneView(loadImage("resources/plane3.png"));
        planeController =new PlaneController(planeView, planeModel);
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
                    bulletModel= new BulletModel(planeController.getPlaneModel().getX() + 35 - 6, planeController.getPlaneModel().getY() - 30);
                    bulletView= new BulletView(loadImage("resources/bullet.png"));
                    bulletController= new BulletController(bulletModel,bulletView);
                    bulletControllerVector.add(bulletController);
            }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        background = loadImage("resources/background.png");

    }

    public Image loadImage(String path) {
        try {
            Image read = ImageIO.read(new File(path));
            return read;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Graphics g) {
        Graphics backBufferGraphic= bufferedImage.getGraphics();
        backBufferGraphic.drawImage(background,0,0,800,600,null);
        planeController.draw(backBufferGraphic);
        for (int i = 0; i < bulletControllerVector.size(); i++) {
            bulletControllerVector.get(i).draw(backBufferGraphic);
        }
                g.drawImage(bufferedImage,0,0,800,600,null);
    }

    @Override
    public void run() {
        while(true){

            try {
                this.repaint();
                Thread.sleep(17);
                for (int i = 0; i < bulletControllerVector.size(); i++) {
                    bulletControllerVector.get(i).getBulletModel().move(0, -5);
                    if(bulletControllerVector.get(i).getBulletModel().getY() < 0)
                        bulletControllerVector.remove(bulletControllerVector.get(i));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
