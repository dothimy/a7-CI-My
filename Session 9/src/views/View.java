package views;

import models.Model;

import java.awt.*;

/**
 * Created by mydt on 12/16/2016.
 */
public interface View {
    void draw(Graphics g, Model model);
}
