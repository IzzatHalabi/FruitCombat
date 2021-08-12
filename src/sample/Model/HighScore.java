package sample.Model;

import sample.Model.Players.Player;

public class HighScore {

    public static Player winner;

    private int score;

    /////   SPECIAL FUNCTION    /////
    public HighScore(){
        score = 0;
    }

    public void updateScore(int val ){
        score += val;
    }

    public static void decidingWinner(Player p1, Player p2) {
        if ( p1.getHitPoint() <= 0 )
            winner = p2;
        else
            winner = p1;
    }


    /////   SETTER AND GETTER   /////
    public int getScore() {
        return score;
    }
}
