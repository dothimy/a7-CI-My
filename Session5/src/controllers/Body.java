package controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import models.Model;

/**
 * Created by mydt on 12/14/2016.
 */
public interface Body {

     Model getModel();
     void onContact(Body other);

}
