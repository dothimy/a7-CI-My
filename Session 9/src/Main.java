/**
 * Created by mydt on 12/16/2016.
 */
public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.run();
    }
}
