package sample.Fruits;

import sample.Debuffs.StunDebuff;
import sample.Moves.StraightMove;

import static sample.Config.*;

public class Watermelon extends Fruit {

    public Watermelon(int id) {
        super(id);
    }

    public Watermelon() {
        super(WATERMELON, WATERMELON_DAMAGE, new StraightMove(WATERMELON_SPEED));
    }

    @Override
    public void hitEffects(int currentTime) {

        StunDebuff debuff = new StunDebuff(getVictim(), STUN_FIXED_TIMER);
        getVictim().getDebuffs().add(debuff);

        System.out.println("PLAYER " + getVictim().getPlayerNum() + " ATTACH " + debuff.info() + " DEBUFF");

    }
}
