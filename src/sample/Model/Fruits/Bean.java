package sample.Model.Fruits;

import sample.Model.Moves.StraightMove;

import static sample.Config.FruitConfig.BEAN;
import static sample.Config.FruitConfig.BEAN_DAMAGE;
import static sample.Config.FruitConfig.BEAN_SPEED;

public class Bean extends Fruit {

    public Bean() {
        super(BEAN, BEAN_DAMAGE, new StraightMove(BEAN_SPEED));
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().computeDamage(getDamage());

    }
}
