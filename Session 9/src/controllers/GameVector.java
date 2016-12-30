package controllers;

/**
 * Created by mydt on 12/24/2016.
 */
public class GameVector {
    public int dx;
    public int dy;

    public GameVector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Double getLength() {
        return Math.sqrt(dx * dx + dy * dy);
    }
}
