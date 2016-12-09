package Controller;

import models.Model;
import utils.Utils;
import views.View;

/**
 * Created by mydt on 12/8/2016.
 */
public class BulletEnemyController extends Controller {
    public static BulletEnemyController createBulletEnemy(int x, int y){

        BulletEnemyController bulletEnemyController=new BulletEnemyController(
                new Model(x+35-6,y-30,13,33),
                new View(Utils.loadImage("resources/enemy_bullet.png"))
                );
        return bulletEnemyController;
    }

    public BulletEnemyController(Model model, View view) {
        super(model, view);
    }
    public  void run(){
        this.model.move(0,2);
    }
}
