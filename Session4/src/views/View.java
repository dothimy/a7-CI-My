package views;

import models.Model;

import java.awt.*;

/**
 * Created by mydt on 12/7/2016.
 */
public class View {
    Image image;

    public View(Image image) {
        this.image = image;
    }
    public void draw(Graphics g, Model model){
        g.drawImage(image,model.getX(),model.getY(),model.getWidth(),model.getHeight(),null);

    }
}
