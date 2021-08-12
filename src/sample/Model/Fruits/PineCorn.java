package sample.Model.Fruits;

import sample.Model.Moves.TargetMove;

import static sample.Config.FruitConfig.PINECORN;
import static sample.Config.FruitConfig.PINECORN_DAMAGE;
import static sample.Config.FruitConfig.PINECORN_SPEED;

public class PineCorn extends Fruit {

    public PineCorn(int id) {
        super(id);
    }

    public PineCorn() {
        super(PINECORN, PINECORN_DAMAGE, new TargetMove(PINECORN_SPEED));
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().computeDamage(getDamage());

    }
}
