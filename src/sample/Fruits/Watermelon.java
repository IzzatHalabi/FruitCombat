package sample.Fruits;

import sample.PlayerStates.PlayerStun;

import static sample.Config.*;

public class Watermelon extends Fruit {

    public Watermelon(int id) {
        super(id);
    }

    public Watermelon() {
        super(WATERMELON, WATERMELON_DAMAGE, WATERMELON_STUN, STUN_FIXED_TIMER);
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().setStatus(new PlayerStun(getVictim(), STUN_FIXED_TIMER));
        getVictim().getHighScore().updateScore(STUN_SCORE);
    }
}
