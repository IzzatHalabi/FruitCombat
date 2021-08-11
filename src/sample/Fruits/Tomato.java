package sample.Fruits;

import sample.Moves.StraightMove;

import static sample.Config.*;

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
