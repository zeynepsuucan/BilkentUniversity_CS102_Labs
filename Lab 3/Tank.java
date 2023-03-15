import java.awt.*;

public class Tank extends EnemyVehicle {

    public Tank(int minX, int maxX, int y) {
        super(minX, maxX, y);
    }

    public void takeDamage(double damage) {

        begDamage -= damage/2;

        if (begDamage <= 0) {
            isDestroyed = true;
        } else
            isDestroyed = false;
    }

    public String getType(){
        return "Tank";
    }


    public String toString() {
        return "\n A " + this.getType() + " is at location (" 
        + this.getLocation().getX() + ", " + this.getLocation().getY() + "). It has " + this.begDamage + " points left.";
    }



}
