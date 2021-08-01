package sample.Fruits;

import sample.Player;
import sample.Position;

import java.util.ArrayList;

import static sample.Config.*;

public abstract class Fruit {

    private int id;
    private Position pos = new Position();
    private int playerNum = 0;
    private int fruitType = 1;
    private int damage = 0;
    private boolean canStun = false;
    private boolean hitOnce = false;
    private boolean standBy = true;

    private Player victim;
    private int stunTimer;

    public abstract void hitEffects(int currentTime);

    /// SPECIAL FUNCTION ///
    public Fruit(int id) {
        this.id = id;
        victim = null;
        stunTimer = 0;
    }

    public Fruit ( int origPosX, int origPosY ){
        pos.setOrigX( origPosX );
        pos.setOrigY( origPosY );
        returnToStore();

        victim = null;
        stunTimer = 0;
    }

    public Fruit( int playerNum, Fruit prevFruit, int posX, int posY, int fruitType, int damage, boolean canStun, int stunTimer){
        this.playerNum = playerNum;
        this.fruitType = fruitType;
        this.damage = damage;
        this.canStun = canStun;
        hitOnce = false;
        standBy = false;
        pos = prevFruit.pos;

        if ( playerNum == PLAYER_1)
            pos.setX( posX + PLAYER_WIDTH);
        else if ( playerNum == PLAYER_2)
            pos.setX( posX - FRUIT_WIDTH);

        pos.setY( posY + ( PLAYER_HEIGHT / 4) );

        victim = null;
        this.stunTimer = stunTimer;
    }

    public void init(int origPosX, int origPosY) {
        pos.setOrigX( origPosX );
        pos.setOrigY( origPosY );
        returnToStore();
    }

    public void move(){
        if ( !standBy )
            if ( playerNum == PLAYER_1)
                pos.setX( pos.getX() + SPEED );
            else if ( playerNum == PLAYER_2)
                pos.setX( pos.getX() - SPEED );
    }

    public void returnToStore(){
        hitOnce = true;
        standBy = true;
        pos.setX( pos.getOrigX() );
        pos.setY( pos.getOrigY() );
    }

    public boolean hitCheck( ArrayList<Player> players ){

        for (Player player : players) {
            if (! hitCondition(player.getPos())) continue;
            victim = player;

            return true;
        }
        return false;
    }

    private boolean hitCondition(Position playerPos) {
        return ! hitOnce
                && (pos.getX() + FRUIT_WIDTH >= playerPos.getX()
                && pos.getX() <= playerPos.getX() + PLAYER_WIDTH
                && pos.getY() + FRUIT_HEIGHT >= playerPos.getY()
                && pos.getY() <= playerPos.getY() + PLAYER_HEIGHT);
    }

    public boolean checkOutOfBound(){
        return pos.getX() + FRUIT_WIDTH < 0 || pos.getX() > FRAME_WIDTH;
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

    public int getDamage() {
        return damage;
    }

    public Player getVictim() {
        return victim;
    }

    public void setVictim(Player victim) {
        this.victim = victim;
    }
}





