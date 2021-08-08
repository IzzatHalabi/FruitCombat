package sample.Players;

import sample.Fruits.Fruit;
import sample.Fruits.FruitPocket;
import sample.Fruits.Tomato;
import sample.HighScore;
import sample.Position;
import sample.PlayerStates.*;
import sample.Fruits.Watermelon;

import static sample.Config.*;

public class Player {

    private Position pos = new Position();
    private HighScore highScore = new HighScore();
    private String name;
    private int playerNum;
    private int hitPoint;
    private boolean dead;

    private PlayerState state;

    private FruitPocket pocket;

    // SPECIAL FUNCTION ///
    public Player( int playerNum, int posX, int posY ){
        this.playerNum = playerNum;
        pos.setX( posX );
        pos.setY( posY );
        hitPoint = STARTING_HP;
        state = new PlayerIdleGround(this);

        Position pos;
        if (playerNum == PLAYER_1) {
            pos = new Position(20 + FRUIT_WIDTH, 45);
        } else {
            pos = new Position(FRAME_WIDTH - 120 + FRUIT_WIDTH, 45);
        }
        pocket = new FruitPocket(this, pos);

    }

    public void jump(){
        if ( pos.getY() >= CLOUD ) pos.setY( pos.getY() - FLY_SPEED);
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
    }

    public void specialAttack() {
        state = new PlayerAttack(this, ATTACKING_FIXED_TIMER);
        pocket.deploy(new Watermelon());
    }

    public void checkStatus() {
        if (state.isActive()) return;
        state = new PlayerIdleGround(this);
    }

    public boolean checkHitPoint(){
        if ( hitPoint <= 0 )
            dead = true;
        return dead;
    }




    /// SETTER AND GETTER  ///
    public int getHitPoint() {
        return hitPoint;
    }

    public void computeDamage(int damage) {
        hitPoint = hitPoint - damage;
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

    public void setState(PlayerState newState) {
        state = newState;
    }

    public void setState(Fruit fruit, PlayerState newState) {
        state = state.modifyState(fruit, newState);
    }

    public void setState(PlayerState newState, int statusTimer) {
        newState.setEndTimer(statusTimer);
        state = newState;
    }

    public FruitPocket getPocket() {
        return pocket;
    }
}