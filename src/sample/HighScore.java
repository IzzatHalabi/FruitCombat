package sample;

public class HighScore {

    public final static int DAMAGE_SCORE = -5;
    public final static int STUN_SCORE = -5;
    public final static int GUARD_SCORE = 10;

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
