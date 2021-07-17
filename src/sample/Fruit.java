package sample;

import java.util.ArrayList;

public class Fruit {

    private Position pos = new Position();
    private int playerNum = 0;
    private int fruitType = 1;
    private int damage = 0;
    private boolean canStun = false;
    private boolean hitOnce = false;
    private boolean standBy = true;

    public final static int SPEED = 5;
    public final static int TOMATO = 1;
    public final static int WATERMELON = 2;
    public final static int TOMATO_DAMAGE = 10;
    public final static int WATERMELON_DAMAGE = 0;
    public final static boolean TOMATO_STUN = false ;
    public final static boolean WATERMELON_STUN = true;




    /// SPECIAL FUNCTION ///
    public Fruit ( int origPosX, int origPosY ){
        pos.setOrigX( origPosX );
        pos.setOrigY( origPosY );
        returnToStore();
    }

    public Fruit( int playerNum, Fruit prevFruit, int posX, int posY, int fruitType, int damage, boolean canStun){
        this.playerNum = playerNum;
        this.fruitType = fruitType;
        this.damage = damage;
        this.canStun = canStun;
        hitOnce = false;
        standBy = false;
        pos = prevFruit.pos;

        if ( playerNum == Player.PLAYER1 )
            pos.setX( posX + Main.PLAYER_WIDTH);
        else if ( playerNum == Player.PLAYER2 )
            pos.setX( posX - Main.FRUIT_WIDTH);

        pos.setY( posY + ( Main.PLAYER_HEIGHT * 1 / 4) );
    }


    public void move(){
        if ( !standBy )
            if ( playerNum == Player.PLAYER1 )
                pos.setX( pos.getX() + SPEED );
            else if ( playerNum == Player.PLAYER2 )
                pos.setX( pos.getX() - SPEED );
    }


    public void returnToStore(){
        hitOnce = true;
        standBy = true;
        pos.setX( pos.getOrigX() );
        pos.setY( pos.getOrigY() );
    }


    public void checkOutOfBound(){
        if ( pos.getX() + Main.FRUIT_WIDTH < 0 || pos.getX() > Main.FRAME_WIDTH ) {
            returnToStore();
        }
    }


    public void stun( Player p ){
        p.setBeingHit( false );
        p.setStunOn( true );
        p.setStunTimer( p.STUN_FIXED_TIMER );
    }


    public void hitCheck( ArrayList<Player> p ){
        for ( int i = 0; i < p.size(); i++ ) {
            if ( !hitOnce &&
                    ( pos.getX() + Main.FRUIT_WIDTH >= p.get(i).getPos().getX() &&
                            pos.getX() <= p.get(i).getPos().getX() + Main.PLAYER_WIDTH &&
                            pos.getY() + Main.FRUIT_HEIGHT >= p.get(i).getPos().getY() &&
                            pos.getY() <= p.get(i).getPos().getY() + Main.PLAYER_HEIGHT)) {

                p.get(i).setBeingHit(true);
                returnToStore();

                if ( !p.get(i).isGuardOn() ) {
                    p.get(i).setHitPoint( p.get(i).getHitPoint() - damage);
                    p.get(i).setHitTimer( Player.HIT_FIXED_TIMER );
                    p.get(i).getHighScore().updateScore( HighScore.DAMAGE_SCORE );
                }
                else {
                    p.get(i).getHighScore().updateScore( HighScore.GUARD_SCORE );
                    p.get(i).setBeingHit(false);
                }

                if ( canStun ) {
                    stun( p.get(i) );
                    p.get(i).getHighScore().updateScore( HighScore.STUN_SCORE );
                }
            }
        }
    }




    /// SETTER AND GETTER ///
    public Position getPos() {
        return pos;
    }

    public int getFruitType() {
        return fruitType;
    }

    public boolean isStandBy() {
        return standBy;
    }
}





