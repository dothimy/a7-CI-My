package controllers;

        import models.PlaneModel;
        import views.PlaneView;

        import java.awt.*;
        import java.awt.event.KeyEvent;

/**
 * Created by mydt on 12/6/2016.
 */
public class PlaneController {
    private PlaneView planeView;
    private PlaneModel planeModel;
    private KeySetting keySetting;
    public PlaneController(PlaneView planeView, PlaneModel planeModel) {
        this.planeView = planeView;
        this.planeModel = planeModel;
    }

    public PlaneView getPlaneView() {
        return planeView;
    }

    public void setPlaneView(PlaneView planeView) {
        this.planeView = planeView;
    }

    public KeySetting getKeySetting() {
        return keySetting;
    }

    public PlaneModel getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(PlaneModel planeModel) {
        this.planeModel = planeModel;
    }

    public void setKeySetting(KeySetting keySetting) {
        this.keySetting = keySetting;
    }

    public void KeyPressed(KeyEvent e){
        if(keySetting!=null){
            int KeyEvent = e.getKeyCode();
            if(KeyEvent==keySetting.KeyUp){
                planeModel.move(0,-5);
            }
            else if(KeyEvent==keySetting.KeyDown){
                planeModel.move(0,5);

            }else if(KeyEvent==keySetting.KeyRight){
                planeModel.move(-5,0);

            }else if(KeyEvent==keySetting.KeyLeft){
                planeModel.move(5,0);
            }

    }
}
    public void draw(Graphics g){
        planeView.draw(g,planeModel);
    }
    public void run(){

    }
}
