package controllers;

import models.BulletModel;
import views.BulletView;

import java.awt.*;

/**
 * Created by mydt on 12/6/2016.
 */
public class BulletController {
    private BulletModel bulletModel;
    private BulletView bulletView;
    private KeySetting keysetting;

    public BulletController(BulletModel bulletModel, BulletView bulletView) {
        this.bulletModel = bulletModel;
        this.bulletView = bulletView;
        this.keysetting = keysetting;
    }

    public BulletModel getBulletModel() {
        return bulletModel;
    }

    public BulletView getBulletView() {
        return bulletView;
    }

    public KeySetting getKeysetting() {
        return keysetting;
    }

    public void setBulletModel(BulletModel bulletModel) {
        this.bulletModel = bulletModel;
    }

    public void setBulletView(BulletView bulletView) {
        this.bulletView = bulletView;
    }

    public void setKeysetting(KeySetting keysetting) {
        this.keysetting = keysetting;
    }

    public void draw(Graphics g){
        bulletView.draw(g,bulletModel);
    }
}
