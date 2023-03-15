import java.awt.*;
public class Helicopter extends EnemyVehicle {

    int speed = 3;

    public Helicopter(int minX, int maxX, int y) {
        super(minX, maxX, y);
    }

    public void move() {
        a++;
        point1.setLocation(point1.getX(), point1.getY()-speed);
        speed++;
    }

    public String getType(){
        return "Helicopter";
    }


    public String toString() {
        return "\n A " + this.getType() + " is at location (" 
        + this.getLocation().getX() + ", " + this.getLocation().getY() + "). It has " + this.begDamage + " points left.";
    }
}
