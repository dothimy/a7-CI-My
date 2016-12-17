package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by mydt on 12/7/2016.
 */
public class Utils {
    public static Image loadImage(String path) {
        try {
            Image read = ImageIO.read(new File(path));
            return read;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}