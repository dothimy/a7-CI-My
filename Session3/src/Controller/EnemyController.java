package Controller;

import controllers.Controller;
import models.Model;
import utils.Utils;
import views.View;

/**
 * Created by mydt on 12/8/2016.
 */
public class EnemyController extends Controller{

    public EnemyController(Model model, View view) {
        super(model, view);
    }
    public void run(){
        this.model.move(0,1);
    }
    public static EnemyController createEnemy(int x,int y){
        EnemyController enemyController=new EnemyController(
                new Model(200,0,70,50),
                new View(Utils.loadImage("resources/enemy_plane_white_1.png"))
        );
        return enemyController;
    }


}
