package sample.Model.Fruits;

import sample.Model.Moves.Move;
import sample.Model.Moves.MoveDataBinder;
import sample.Model.Moves.NoMove;
import sample.Model.Players.Player;
import sample.Model.Position;

import static sample.Config.Config.*;

public abstract class Fruit {

    private int id;
    private Position pos = new Position();
    private int fruitType = 1;
    private int damage = 0;
    private boolean hitOnce = false;
    private boolean standBy = true;

    private Player victim;
    private Move move;

    public abstract void hitEffects(int currentTime);

    /// SPECIAL FUNCTION ///
    public Fruit(int id) {

        this.id = id;
        victim = null;
        move = new NoMove();
    }

    public Fruit(int fruitType, int damage, Move move){

        this.fruitType = fruitType;
        this.damage = damage;
        this.move = move;
        move.setFruit(this);

    }

    public void init(int id, MoveDataBinder binder) {

        this.id = id;
        move.bind(binder);
        victim = binder.getVictim();
    }

    public void updatePosX(int value) {
        pos.setX(pos.getX() + value);
    }

    public void updatePosY(int value) {
        pos.setY(pos.getY() + value);
    }

    public void move(){
        move.execute();
    }

    public void returnToStore(){
        hitOnce = true;
        standBy = true;
        pos.setX( pos.getOrigX() );
        pos.setY( pos.getOrigY() );
    }

    public boolean hitCheck(){
        return hitCondition(victim.getPos());
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

    public void setMove(Move move) {
        this.move = move;
    }
}





