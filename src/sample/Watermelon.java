package sample;

import sample.Fruits.Fruit;
import sample.State.StunState;

import static sample.Config.*;

public class Watermelon extends Fruit {

    public Watermelon(int id) {
        super(id);
    }

    public Watermelon(int playerNum, Fruit prevFruit, Position playerPos) {
        super(playerNum, prevFruit, playerPos.getX(), playerPos.getY(),
                WATERMELON, WATERMELON_DAMAGE, WATERMELON_STUN, STUN_FIXED_TIMER);
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().setStatus(new StunState(getVictim().getPlayerNum(), currentTime, STUN_FIXED_TIMER));
        getVictim().getHighScore().updateScore(STUN_SCORE);
    }
}
