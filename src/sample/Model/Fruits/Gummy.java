package sample.Model.Fruits;

import sample.Model.Debuffs.SlowDebuff;
import sample.Model.Moves.StraightMove;

import static sample.Config.Config.*;
import static sample.Config.FruitConfig.*;

public class Gummy extends Fruit {

    public Gummy(int id) {
        super(id);
    }

    public Gummy() {
        super(GUMMY, GUMMY_DAMAGE, new StraightMove(GUMMY_SPEED));
    }

    @Override
    public void hitEffects(int currentTime) {

        SlowDebuff debuff = new SlowDebuff(getVictim(), SLOW_FIXED_TIMER, GUMMY_SLOW);
        getVictim().getDebuffs().add(debuff);

        System.out.println("PLAYER " + getVictim().getPlayerNum() + " ATTACH " + debuff.info() + " DEBUFF");

    }
}
