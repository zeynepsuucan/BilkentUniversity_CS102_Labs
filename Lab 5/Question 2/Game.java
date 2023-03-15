public class Game {

    String name;
    int score;
    int GB;

    public Game(String name, int GB, int score){
        this.name = name;
        this.GB = GB;
        this.score = score;
    }

    public int getScore(){
        return score;
    }


    public int getGB(){
        return GB;
    }
    
}
