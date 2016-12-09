package models;

/**
 * Created by mydt on 12/7/2016.
 */
public class Model {
    private int x;
    private int y;
    private int width;
    private int height;

    public Model(int x, int y, int width, int height) {
        this.y = y;
        this.width = width;
        this.height = height;
        this.x = x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public void move(int dx,int dy){
        this.x+=dx;
        this.y+=dy;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}

