package models;

/**
 * Created by mydt on 12/6/2016.
 */
public class BulletModel {
    private int x;
    private int y;

    public BulletModel(int x, int y) {
        this.x = x;
        this.y = y;
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
}
