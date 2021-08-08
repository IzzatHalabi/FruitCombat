package sample.Fruits;

import sample.Players.Player;
import sample.Position;

import java.util.ArrayList;

import static sample.Config.*;

public abstract class Fruit {

    private int id;
    private Position pos = new Position();
    private int fruitType;
    private int damage;
    private boolean hitOnce = false;
    private boolean standBy = true;
    private Player victim;
    private int direction;

    private int attackLevel;
    private int hitDuration;

    public abstract void hitEffects();

    /// SPECIAL FUNCTION ///
    public Fruit(int id) {
        this.id = id;
        victim = null;
        fruitType = TOMATO;
    }

    public Fruit(int fruitType, int damage, int attackLevel, int hitDuration){
        this.fruitType = fruitType;
        this.damage = damage;
        this.attackLevel = attackLevel;
        this.hitDuration = hitDuration;

        hitOnce = false;
        standBy = false;
        victim = null;
        direction = 0;
    }

    public void throwInit(int id, Position playerPos, int direction, int throwStart) {

        this.id = id;
        this.direction = direction;

        pos.setX(playerPos.getX() + throwStart);
        pos.setY(playerPos.getY() + (PLAYER_HEIGHT/4));
    }

    public void move(){
        if (! standBy) {
            pos.setX(pos.getX() + direction);
        }
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

            System.out.println("Fruit ID: " + id);

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

    public void setHitOnce(boolean hitOnce) {
        this.hitOnce = hitOnce;
    }

    public void setStandBy(boolean standBy) {
        this.standBy = standBy;
    }

    public int getId() {
        return id;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public int getHitDuration() {
        return hitDuration;
    }
}





