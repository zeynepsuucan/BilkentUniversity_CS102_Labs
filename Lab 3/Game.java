import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game implements Difficulty {

    Random rand = new Random();
    Scanner in = new Scanner(System.in);


    
    public ArrayList<EnemyVehicle> getEnemies = new ArrayList<EnemyVehicle>();

    final int STARTING_DISTANCE = 20;
    private int dif;
    private int playersScore;
    private int numOfEVPassed;

    boolean gameOver;

    public int speedUp(){
        return (numOfEVPassed+1)/2;
    }

    Player player1;

    public int getPlayersScore(){
        return playersScore;
    }
    

    public Game(int difficulty) {

        dif = difficulty;

        player1 = new Player();

        for (int i = 0; i < getDifficulty() * 2; i++) {
            getNewRandomEnemyVehicle();
        }

    }

    public ArrayList<EnemyVehicle> getEnemies() {
        return getEnemies;
    }

    public void play() {

        System.out.println("Enter the level of difficulty: ");
        dif = in.nextInt();
        this.setDifficulty(dif);

        while (isGameOver() == false) {
            System.out.println("Enter x and y coordinates to bomb: ");
            int xBomb = in.nextInt();
            int yBomb = in.nextInt();
            player1.attack(xBomb, yBomb, getEnemies);
            enemiesTurn();
            printGameState();
        }
    }

    public void setDifficulty(int a) {
        dif = a;
    }

    public int getDifficulty() {
        return dif;

    }

    public EnemyVehicle getNewRandomEnemyVehicle() {

        EnemyVehicle a;
        double rannum2 = Math.random();
        if (rannum2 > 0.5) {
            a = new Tank(0, this.getDifficulty() * 5 , STARTING_DISTANCE);
            getEnemies.add(a);
        }

        else {
            a = new Helicopter(0, this.getDifficulty() * 5, STARTING_DISTANCE);
            getEnemies.add(a);
        }

        return a;
    }

    public void enemiesTurn() {
        ArrayList<EnemyVehicle> removed = new ArrayList<EnemyVehicle>();
        for (int i = 0; i < getDifficulty() * 2; i++) {

                getEnemies.get(i).move();


            if (getEnemies.get(i).isDestroyed() == true) {
                removed.add(getEnemies.get(i));
                getNewRandomEnemyVehicle();
                playersScore += 10;

            }
            
            if(getEnemies.get(i).hasPassedBorder()){
                numOfEVPassed++;
                removed.add(getEnemies.get(i));
                getNewRandomEnemyVehicle();

            }
        }
        for (int i = 0; i < removed.size(); i++) {
            getEnemies.remove(removed.get(i));
        }
    }

    public boolean isGameOver() {
        if (playersScore >= 50 || numOfEVPassed >= this.getDifficulty() * 5) {
            gameOver = true;

            if(playersScore >= 50){
                System.out.println("YOU WON! ENEMIES COULDN'T PASS THE BORDER!");
            }
            else{
                System.out.println("YOU LOST! ENEMIES PASSED THE BORDER!");
            }
        } else
            gameOver = false;

        return gameOver;
    }

    public void printGameState() {
        GamePlotter plotter = new GamePlotter(this);
        plotter.plot();
        System.out.println("Player's score: " + this.getPlayersScore());
        System.out.println("Enemy vehicles having passed the border: " + numOfEVPassed);
        System.out.println("Enemy vehicles in the game: " + getEnemies());
    }

}
