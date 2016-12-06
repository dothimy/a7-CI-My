package models;

/**
 * Created by mydt on 12/6/2016.
 */
public class PlaneModel {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PlaneModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void move(int dx,int dy){
        this.x+=dx;
        this.y+=dy;
    }

}
