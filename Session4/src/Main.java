/**
 * Created by mydt on 12/6/2016.
 */
public class Main {
    public static void main(String[] args) {
        GameWindown gameWindown= new GameWindown();
        new Thread(gameWindown).start();
    }
}
