package controllers;

import models.Model;

/**
 * Created by mydt on 12/16/2016.
 */
public interface Body {
    Model getModel();
    void onContact(Body other);
}
