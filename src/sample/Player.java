package sample;

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


    public final static int STUN_FIXED_TIMER = 80;
    public final static int GUARD_FIXED_TIMER = 40;
    public final static int HIT_FIXED_TIMER = 15;
    public final static int ATTACKING_FIXED_TIMER = 10;

    public final static int PLAYER1 = 0;
    public final static int PLAYER2 = 1;
    public final static int STARTING_HP = 100;
    public final static int FLY_SPEED = 70;
    public final static int GRAVITY = 2;



    // SPECIAL FUNCTION ///
    public Player( int playerNum, int posX, int posY ){
        this.playerNum = playerNum;
        pos.setX( posX );
        pos.setY( posY );
        hitPoint = STARTING_HP;
    }

    public void fly(){
        if ( pos.getY() >= Main.CLOUD )
            pos.setY( pos.getY() - FLY_SPEED);
        flying = true;
    }

    public void fall(){
        if ( pos.getY() <= Main.GROUND )
            pos.setY( pos.getY() + GRAVITY);
        flying = false;
    }

    public void guard(){
        guardOn = true;
        guardTimer = GUARD_FIXED_TIMER;
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


    public boolean statusMove(){
        if ( stunOn || beingHit || guardOn || attacking )
            return false;
        else
            return true;
    }

    public boolean checkHitPoint(){
        if ( hitPoint <= 0 )
            dead = true;
        return dead;
    }

    public Fruit attack( Fruit prevFruit ){
        attacking = true;
        attackingTimer = ATTACKING_FIXED_TIMER;
        return new Fruit( playerNum, prevFruit, pos.getX(), pos.getY(),
                Fruit.TOMATO, Fruit.TOMATO_DAMAGE, Fruit.TOMATO_STUN);
    }

    public Fruit specialAttack( Fruit prevFruit ) {
        attacking = true;
        attackingTimer = ATTACKING_FIXED_TIMER;
        return new Fruit( playerNum, prevFruit, pos.getX(), pos.getY(),
                Fruit.WATERMELON, Fruit.WATERMELON_DAMAGE, Fruit.WATERMELON_STUN );

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
}
