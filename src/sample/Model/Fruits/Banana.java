package sample.Model.Fruits;

import sample.Model.Moves.BidirectionalMove;

import static sample.Config.FruitConfig.BANANA;
import static sample.Config.FruitConfig.BANANA_DAMAGE;
import static sample.Config.FruitConfig.BANANA_SPEED;

public class Banana extends Fruit {

    public Banana(int id) {
        super(id);
    }

    public Banana() {
        super(BANANA, BANANA_DAMAGE, new BidirectionalMove(BANANA_SPEED));
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().computeDamage(getDamage());

    }
}
