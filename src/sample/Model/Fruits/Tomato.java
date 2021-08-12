package sample.Model.Fruits;

import sample.Model.Moves.StraightMove;

import static sample.Config.FruitConfig.TOMATO;
import static sample.Config.FruitConfig.TOMATO_DAMAGE;
import static sample.Config.FruitConfig.TOMATO_SPEED;

public class Tomato extends Fruit {

    public Tomato(int id) {
        super(id);
    }

    public Tomato() {
        super(TOMATO, TOMATO_DAMAGE, new StraightMove(TOMATO_SPEED));
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().computeDamage(getDamage());

    }
}
