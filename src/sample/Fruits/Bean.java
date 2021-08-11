package sample.Fruits;

import sample.Moves.StraightMove;

import static sample.Config.*;

public class Bean extends Fruit {

    public Bean() {
        super(BEAN, BEAN_DAMAGE, new StraightMove(BEAN_SPEED));
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().computeDamage(getDamage());

    }
}
