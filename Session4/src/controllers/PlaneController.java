package controllers;

        import models.Model;
        import utils.Utils;
        import views.View;

        import java.awt.*;
        import java.awt.event.KeyEvent;

/**
 * Created by mydt on 12/6/2016.
 */
public class PlaneController extends Controller {
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
}
