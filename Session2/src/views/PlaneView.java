package views;

import models.PlaneModel;

import java.awt.*;

/**
 * Created by mydt on 12/6/2016.
 */
public class PlaneView {
    Image image;

    public PlaneView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, PlaneModel planeModel){
        g.drawImage(image,planeModel.getX(),planeModel.getY(),70,50,null);
    }
}
