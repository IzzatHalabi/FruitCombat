package sample;

import sample.Fruits.Fruit;
import sample.Fruits.FruitGroup;
import sample.Fruits.FruitPocket;
import sample.Fruits.Tomato;
import sample.State.*;

import static sample.Config.*;

public class Player {

    private Position pos = new Position();
    private HighScore highScore = new HighScore();
    private String name;
    private int playerNum;
    private int hitPoint;
    private int stunTimer = 0;
    private int guardTimer = 0;
    private int hitTimer = 0;
    private int attackingTimer = 0;
    private boolean guardOn;
    private boolean stunOn;
    private boolean flying;
    private boolean beingHit;
    private boolean dead;
    private boolean attacking;

    private ActionState status;

    private FruitPocket pocket;

    // SPECIAL FUNCTION ///
    public Player( int playerNum, int posX, int posY ){
        this.playerNum = playerNum;
        pos.setX( posX );
        pos.setY( posY );
        hitPoint = STARTING_HP;
        status = new IdleGroundState(playerNum, 0, 0);


    }

    public void fly(){
        if ( pos.getY() >= CLOUD )
            pos.setY( pos.getY() - FLY_SPEED);
        flying = true;
    }

    public void fall(){
        if ( pos.getY() <= GROUND )
            pos.setY( pos.getY() + GRAVITY);
        flying = false;
    }

    public void guard(int currentTimer){
        status = new GuardState(playerNum, currentTimer, ATTACKING_FIXED_TIMER);
    }

    public void checkStatus(int currentTimer) {
        if (! status.isActive(currentTimer)) {
            status = new IdleGroundState(playerNum, currentTimer, 0);
        }
    }

    public void guardStatus(){
        guardTimer--;
        if ( guardTimer <= 0 )
            guardOn = false;
    }

    public void stunStatus(){
        stunTimer--;
        if ( stunTimer <= 0 )
            stunOn = false;
    }

    public void hitStatus(){
        hitTimer--;
        if ( hitTimer <= 0 )
            beingHit = false;
    }


    public void attackingStatus(){
        attackingTimer--;
        if ( attackingTimer <= 0 )
            attacking = false;
    }

    public void beingHit() {

    }


    public boolean statusMove(){
        return ! (status instanceof StunState
                || status instanceof BeingHitState);
    }

    public boolean checkHitPoint(){
        if ( hitPoint <= 0 )
            dead = true;
        return dead;
    }

    public Fruit attack(Fruit prevFruit , int currentTimer){

        status = new AttackState(playerNum, currentTimer, ATTACKING_FIXED_TIMER);

        return new Tomato(playerNum, prevFruit, pos);
    }

    public Fruit specialAttack( Fruit prevFruit, int currentTimer ) {

        status = new AttackState(playerNum, currentTimer, ATTACKING_FIXED_TIMER);

        return new Watermelon(playerNum, prevFruit, pos);
    }






    /// SETTER AND GETTER  ///
    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public boolean isGuardOn() {
        return guardOn;
    }

    public boolean isStunOn() {
        return stunOn;
    }

    public void setStunOn(boolean stunOn) {
        this.stunOn = stunOn;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setStunTimer(int stunTimer) {
        this.stunTimer = stunTimer;
    }

    public Position getPos() { return pos; }

    public boolean isBeingHit() {
        return beingHit;
    }

    public void setBeingHit(boolean beingHit) {
        this.beingHit = beingHit;
    }

    public int getGuardTimer() {
        return guardTimer;
    }

    public HighScore getHighScore() {
        return highScore;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setHitTimer(int hitTimer) {
        this.hitTimer = hitTimer;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public ActionState getStatus() {
        return status;
    }

    public void setStatus(ActionState status) {
        this.status = status;
    }

    public FruitPocket getPocket() {
        return pocket;
    }

    public void setPocket(FruitPocket pocket) {
        this.pocket = pocket;
    }
}
