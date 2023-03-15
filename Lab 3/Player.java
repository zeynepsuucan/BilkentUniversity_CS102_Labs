import java.util.ArrayList;

public class Player {


    final double BOMB_RADIUS = 2.0;
    final double DAMAGE = 50.0;
    ArrayList<EnemyVehicle> enemies;


    public Player() {
    }

    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies) {
        this.enemies = enemies;

        for(int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).getLocation().distance(x,y) <= (double)BOMB_RADIUS){
                enemies.get(i).takeDamage(DAMAGE);
            }
        }
    } 
}