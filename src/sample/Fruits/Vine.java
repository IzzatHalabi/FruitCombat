package sample.Fruits;

import sample.Debuffs.DisarmDebuff;

import static sample.Config.*;

public class Vine extends Fruit {

    public Vine(int id) {
        super(id);
    }

    public Vine() {
        super(VINE, VINE_DAMAGE, VINE_STUN, STUN_FIXED_TIMER, VINE_SPEED);
    }

    @Override
    public void hitEffects(int currentTime) {

        DisarmDebuff debuff = new DisarmDebuff(getVictim(), STUN_FIXED_TIMER);
        getVictim().getDebuffs().add(debuff);

        System.out.println("PLAYER " + getVictim().getPlayerNum() + " ATTACH " + debuff.info() + " DEBUFF");

    }
}
