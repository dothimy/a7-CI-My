package controllers;

import java.awt.event.KeyEvent;

/**
 * Created by mydt on 12/6/2016.
 */
public class KeySetting {
    public int KeyUp;
    public int KeyDown;
    public int KeyRight;
    public int KeyLeft;

    public KeySetting(int keyUp, int keyDown, int keyRight, int keyLeft) {
        KeyUp = keyUp;
        KeyDown = keyDown;
        KeyRight = keyRight;
        KeyLeft = keyLeft;
    }

}