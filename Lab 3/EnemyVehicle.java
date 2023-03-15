import javax.security.auth.Destroyable;
import java.awt.*;
import java.util.Random;

public abstract class EnemyVehicle implements Destroyable, Movable {

    final int BASE_SPEED = 3;
    double begDamage = 100.00;
    boolean isDestroyed;
    Random rand = new Random();
    Point point1 = new Point();
    int a = 0;
    boolean passedBorder;

    public EnemyVehicle(int minX, int maxX, int y) {
        int rannum = rand.nextInt(maxX-minX);
        rannum += minX;
        point1.setLocation(rannum, y);
    }

    public int getDistanceToBorder() {
        return 20 - a*BASE_SPEED;
    }

    public abstract String getType(); // doesn't have a body, overriden in tank and helicopter classes

    public Point getLocation(){
        return point1;
    }

    public void takeDamage(double damage) {
        begDamage -= damage;

        if (begDamage <= 0) {
            isDestroyed = true;
        } 
        else
            isDestroyed = false;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void move() {
        a++;
        point1.setLocation(point1.getX(), point1.getY()-3);
    }

    public boolean hasPassedBorder(){
        if(this.getLocation().getY()<=0){
            passedBorder = true;
        }
        return passedBorder;
    }

}