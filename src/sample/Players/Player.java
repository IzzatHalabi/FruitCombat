package sample.Players;

import sample.Fruits.FruitPocket;
import sample.Fruits.Tomato;
import sample.HighScore;
import sample.MainTemp;
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

    private PlayerState status;

    private FruitPocket pocket;

    // SPECIAL FUNCTION ///
    public Player( int playerNum, int posX, int posY ){
        this.playerNum = playerNum;
        pos.setX( posX );
        pos.setY( posY );
        hitPoint = STARTING_HP;
        status = new PlayerIdleGround(this, 0);

        Position pos;
        if (playerNum == PLAYER_1) {
            pos = new Position(20 + FRUIT_WIDTH, 45);
        } else {
            pos = new Position(FRAME_WIDTH - 120 + FRUIT_WIDTH, 45);
        }
        pocket = new FruitPocket(this, pos);

    }

    public void fly(){
        if ( pos.getY() >= CLOUD ) pos.setY( pos.getY() - FLY_SPEED);
    }

    public void fall(){
        if ( pos.getY() <= GROUND ) pos.setY( pos.getY() + GRAVITY);
    }

    public void guard(){
        status = new PlayerGuard(this, ATTACKING_FIXED_TIMER);
    }

    public void attack(){
        status = new PlayerAttack(this, ATTACKING_FIXED_TIMER);
        pocket.deploy(new Tomato());
    }

    public void specialAttack() {

        status = new PlayerAttack(this, ATTACKING_FIXED_TIMER);
        pocket.deploy(new Watermelon());
    }

    public void checkStatus(int currentTimer) {
        if (status.isActive(currentTimer)) return;
        status = new PlayerIdleGround(this, 0);
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

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
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

    public PlayerState getStatus() {
        return status;
    }

    public void setStatus(PlayerState status) {
        this.status = status;
    }

    public FruitPocket getPocket() {
        return pocket;
    }
}
