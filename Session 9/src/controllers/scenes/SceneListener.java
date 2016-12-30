package controllers.scenes;

/**
 * Created by mydt on 12/28/2016.
 */
public interface SceneListener {
    void replaceScene(GameScene newScene, boolean addToBackStack);
}
