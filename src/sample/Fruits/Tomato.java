package sample.Fruits;

import sample.PlayerStates.PlayerBeingHit;

import static sample.Config.*;

public class Tomato extends Fruit {

    public Tomato(int id) {
        super(id);
    }

    public Tomato() {
        super(TOMATO, TOMATO_DAMAGE, TOMATO_STUN, HIT_FIXED_TIMER);
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().setHitPoint(getVictim().getHitPoint() - getDamage());
        getVictim().setStatus(new PlayerBeingHit(getVictim(), HIT_FIXED_TIMER));
        getVictim().getHighScore().updateScore(DAMAGE_SCORE);
    }
}
