package controllers;

        import controllers.manangers.BodyManager;
        import models.Model;
        import utils.Utils;
        import views.View;

        import java.awt.*;
        import java.awt.event.KeyEvent;

/**
 * Created by mydt on 12/6/2016.
 */
public class PlaneController extends Controller implements Body {
    private int Hp=5;
    private static final int SPEED =5 ;
    public KeySetting keySetting;

    public KeySetting getKeySetting() {
        return keySetting;
    }

    public void setKeySetting(KeySetting keySetting) {
        this.keySetting = keySetting;
    }

    public PlaneController(Model model, View view) {
        super( model, view);
        BodyManager.instance.register(this);
    }

    public void KeyPressed(KeyEvent e) {
        if (keySetting != null) {
            int KeyEvent = e.getKeyCode();
            if (KeyEvent == keySetting.KeyUp) {
                model.move(0, -SPEED);
            } else if (KeyEvent == keySetting.KeyDown) {
                model.move(0, SPEED);

            } else if (KeyEvent == keySetting.KeyRight) {
                model.move(-SPEED, 0);

            } else if (KeyEvent == keySetting.KeyLeft) {
                model.move(SPEED, 0);
            }

        }

    }   //utinities

    public static PlaneController createPlane(int x, int y) {
        PlaneController planeController = new PlaneController(
                new Model(x, y, 70, 50),
                new View(Utils.loadImage("resources/plane3.png")));
        return planeController;

    }
    public void onContact(Body other ){
        while(Hp!=0){
            if(other instanceof BulletEnemyController){
                Hp--;
                System.out.println("trung dan " );
            }

        }
        this.getModel().setAlive(false);
        BodyManager.instance.remove(this);


//        if(other instanceof BulletEnemyController){
//            System.out.println("baybay");
//            this.model.setAlive(false);
//            BodyManager.instance.remove(this);
//        }
    }

}
