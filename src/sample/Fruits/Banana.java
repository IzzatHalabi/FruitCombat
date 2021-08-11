package sample.Fruits;

import sample.Moves.BidirectionalMove;

import static sample.Config.BANANA;
import static sample.Config.BANANA_DAMAGE;
import static sample.Config.BANANA_SPEED;

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
