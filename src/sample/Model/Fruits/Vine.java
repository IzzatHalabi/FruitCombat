package sample.Model.Fruits;

import sample.Model.Debuffs.DisarmDebuff;
import sample.Model.Moves.StraightMove;

import static sample.Config.Config.*;
import static sample.Config.FruitConfig.VINE;
import static sample.Config.FruitConfig.VINE_DAMAGE;
import static sample.Config.FruitConfig.VINE_SPEED;

public class Vine extends Fruit {

    public Vine(int id) {
        super(id);
    }

    public Vine() {
        super(VINE, VINE_DAMAGE, new StraightMove(VINE_SPEED));
    }

    @Override
    public void hitEffects(int currentTime) {

        DisarmDebuff debuff = new DisarmDebuff(getVictim(), STUN_FIXED_TIMER);
        getVictim().getDebuffs().add(debuff);

        System.out.println("PLAYER " + getVictim().getPlayerNum() + " ATTACH " + debuff.info() + " DEBUFF");

    }
}
