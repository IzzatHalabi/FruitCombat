package sample.Fruits;

import sample.Debuffs.SlowDebuff;

import static sample.Config.*;

public class Gummy extends Fruit {

    public Gummy(int id) {
        super(id);
    }

    public Gummy() {
        super(GUMMY, GUMMY_DAMAGE, GUMMY_STUN, HIT_FIXED_TIMER, SPEED);
    }

    @Override
    public void hitEffects(int currentTime) {
        SlowDebuff debuff = new SlowDebuff(getVictim(), SLOW_FIXED_TIMER, GUMMY_SLOW);
        getVictim().getDebuffs().add(debuff);

        System.out.println("PLAYER " + getVictim().getPlayerNum() + " ATTACH " + debuff.info() + " DEBUFF");
    }
}
