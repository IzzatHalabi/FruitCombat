package sample.Fruits;

import sample.Moves.Move;
import sample.Moves.MoveDataBinder;
import sample.Moves.NoMove;
import sample.Players.Player;
import sample.Position;

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

    private boolean enable = true;
    private int direction;
    private int throwStart;
    private int speed;

    private Move move;

    public abstract void hitEffects(int currentTime);

    /// SPECIAL FUNCTION ///
    public Fruit(int id) {
        this.id = id;
        victim = null;
        stunTimer = 0;

        move = new NoMove();

    }

    public Fruit(int fruitType, int damage, boolean canStun, int stunTimer, int speed){
        this.fruitType = fruitType;
        this.damage = damage;
        this.canStun = canStun;
        this.speed = speed;
        hitOnce = false;
        standBy = false;
        victim = null;
        this.stunTimer = stunTimer;

        direction = 0;
        throwStart = 0;
    }

    public Fruit(int fruitType, int damage, Move move){

        this.fruitType = fruitType;
        this.damage = damage;
        this.move = move;
        move.setFruit(this);

    }

    public void init(int id, Position playerPos, int direction, int throwStart) {

        this.id = id;
        this.direction = direction * speed;
        this.throwStart = throwStart;

        pos.setX(playerPos.getX() + throwStart);
        pos.setY(playerPos.getY() + (PLAYER_HEIGHT/4));
    }

    public void init(int id, MoveDataBinder binder) {

        this.id = id;
        move.bind(binder);
        victim = binder.getVictim();
    }

    public void updatePosX(int value) {
        pos.setX(pos.getX() + value);
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

    public void setVictim(Player victim) {
        this.victim = victim;
    }

    public boolean isHitOnce() {
        return hitOnce;
    }

    public void setHitOnce(boolean hitOnce) {
        this.hitOnce = hitOnce;
    }

    public void setStandBy(boolean standBy) {
        this.standBy = standBy;
    }

    public void enable() {
        enable = true;
    }

    public void disable() {
        enable = false;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirection() {
        return direction;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}





