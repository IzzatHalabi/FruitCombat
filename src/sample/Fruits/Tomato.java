package sample.Fruits;

import static sample.Config.*;

public class Tomato extends Fruit {

    public Tomato(int id) {
        super(id);
    }

    public Tomato() {
        super(TOMATO, TOMATO_DAMAGE, TOMATO_STUN, HIT_FIXED_TIMER, SPEED);
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().computeDamage(getDamage());
    }
}
