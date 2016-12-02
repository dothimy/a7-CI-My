import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by mydt on 11/30/2016.
 */
public class GameWindow extends Frame {
    Image backgroud;
    Image player1;
    Image player2;
    Image enemy;
    int player1X=500;
    int player1Y=550;
    int player2X=300;
    int player2Y=550;

    public GameWindow() {
        setVisible(true);
        setSize(800, 600);
        addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosing");


            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated");
            }
        });
        try {
            backgroud = ImageIO.read(new File("resources/background.png"));
            player1 = ImageIO.read(new File("resources/plane2.png"));
            player2 = ImageIO.read(new File("resources/plane3.png"));
            enemy = ImageIO.read(new File("resources/enemy_plane_yellow_3.png"));
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addKeyListener(new KeyListener() {//
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W:
                        player2Y-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_S:
                        player2Y+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_A:
                        player2X-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_D:
                        player2X+=5;
                        repaint();
                        break;

                }
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        player1Y-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        player1Y+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        player1X+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        player1X-=5;
                        repaint();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });


    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(backgroud,0,0,800,600,null);
        g.drawImage(player1, player1X,player1Y, 32,32, null);
        g.drawImage(player2, player2X, player2Y, 32,32,null);
        g.drawImage(enemy, 100, 32, 32,32,null);
    }
}

