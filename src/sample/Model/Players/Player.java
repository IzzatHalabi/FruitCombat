package sample.Model.Players;

import sample.Model.Debuffs.DebuffStack;
import sample.Model.Fruits.*;
import sample.Model.HighScore;
import sample.Model.Position;
import sample.Model.PlayerStates.*;

import static sample.Config.Config.*;

public class Player {

    private Position pos = new Position();
    private HighScore highScore = new HighScore();
    private String name;
    private int playerNum;
    private int hitPoint;
    private boolean dead;

    private PlayerState state;

    private FruitPocket pocket;

    private DebuffStack debuffs;

    private int flySpeed;

    // SPECIAL FUNCTION ///
    public Player( int playerNum, int posX, int posY ){
        this.playerNum = playerNum;
        pos.setX( posX );
        pos.setY( posY );
        hitPoint = STARTING_HP;
        state = new PlayerIdleGround(this, 0);

        Position pos;
        if (playerNum == PLAYER_1) {
            pos = new Position(20 + FRUIT_WIDTH, 45);
        } else {
            pos = new Position(FRAME_WIDTH - 120 + FRUIT_WIDTH, 45);
        }
        pocket = new FruitPocket(this, pos);

        debuffs = new DebuffStack();

        flySpeed = FLY_SPEED;

    }

    public void fly(){
        if ( pos.getY() >= CLOUD ) pos.setY( pos.getY() - flySpeed);
//        System.out.println("Fly Speed: " + flySpeed);
    }

    public void fall(){
        if ( pos.getY() <= GROUND ) pos.setY( pos.getY() + GRAVITY);
    }

    public void guard(){
        state = new PlayerGuard(this, GUARD_FIXED_TIMER);
    }

    public void attack(){
        state = new PlayerAttack(this, ATTACKING_FIXED_TIMER);
        pocket.deploy(new Tomato());
//        pocket.deploy(new Vine());
    }

    public void specialAttack() {

        state = new PlayerAttack(this, ATTACKING_FIXED_TIMER);
//        pocket.deploy(new Watermelon());
        pocket.deploy(new PineCorn());
    }

    public void checkStatus() {
        if (state.isActive()) return;
        state = new PlayerIdleGround(this, 0);
    }

    public boolean checkHitPoint(){
        if ( hitPoint <= 0 )
            dead = true;
        return dead;
    }

    public void computeDamage(int damage) {
        hitPoint -= damage;
    }

    public void increaseSpeed(int increment) {
        flySpeed += increment;
    }

    public void reduceSpeed(int reduction) {
        flySpeed -= reduction;
    }




    /// SETTER AND GETTER  ///
    public int getHitPoint() {
        return hitPoint;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public Position getPos() { return pos; }

    public HighScore getHighScore() {
        return highScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public FruitPocket getPocket() {
        return pocket;
    }

    public DebuffStack getDebuffs() {
        return debuffs;
    }

    public int getFlySpeed() {
        return flySpeed;
    }
}
