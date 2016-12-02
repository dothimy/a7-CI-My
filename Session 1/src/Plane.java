import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by mydt on 12/1/2016.
 */

public class Plane {
    protected int x;
    protected int y;
    protected Image image;

    public int getX() {
        return x;
    }
    /*
        0---------------------------------->x
        |
        |
        |
        |
        |
        y
     */

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(String path) throws IOException {
        this.image = ImageIO.read(new File(path));
    }

    public void moveUp(){
        this.y=y-5;
    }
    public void moveDown(){
        this.y+=5;
    }
    public void moveRight(){// right là trái hay phải nhỉ
        this.x=x+5;
        //thế cái trục y kia nó ngược à, em tưởng nó theo chiều giảm dần, ok
    }
    public void moveLeft(){
        this.x=x-5;
    }
}
