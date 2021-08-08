package sample.Fruits;

import sample.HitEffectProcessor;
import sample.PlayerStates.PlayerBeingHit;
import sample.PlayerStates.PlayerStun;

import static sample.Config.*;

public class Watermelon extends Fruit {

    public Watermelon() {
        super(WATERMELON, WATERMELON_DAMAGE, ATTACK_LEVEL_2, STUN_FIXED_TIMER);
    }

    @Override
    public void hitEffects() {

        HitEffectProcessor processor = new HitEffectProcessor(getVictim(), this);
        processor.setState(new PlayerBeingHit(getVictim()));
        processor.execute();
    }
}
