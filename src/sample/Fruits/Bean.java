package sample.Fruits;

import static sample.Config.*;

public class Bean extends Fruit {

    public Bean() {
        super(BEAN, BEAN_DAMAGE, BEAN_STUN, ATTACKING_FIXED_TIMER, BEAN_SPEED);
    }

    @Override
    public void hitEffects(int currentTime) {
        getVictim().computeDamage(getDamage());
    }
}
