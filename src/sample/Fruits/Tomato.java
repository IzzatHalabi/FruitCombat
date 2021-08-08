package sample.Fruits;

import sample.HitEffectProcessor;
import sample.PlayerStates.PlayerBeingHit;
import sample.PlayerStates.PlayerGuard;

import java.util.ArrayList;
import java.util.Collection;

import static sample.Config.*;

public class Tomato extends Fruit {

    public Tomato(int id) {
        super(id);
    }

    public Tomato() {
        super(TOMATO, TOMATO_DAMAGE, ATTACK_LEVEL_1, HIT_FIXED_TIMER);
    }

    @Override
    public void hitEffects() {

//        getVictim().setState(this, new PlayerBeingHit(getVictim()));
//        getVictim().computeDamage(getDamage());
//        getVictim().getHighScore().updateScore(DAMAGE_SCORE);

        ArrayList<Integer> effectCheck = new ArrayList<>();
        effectCheck.add(DAMAGE_EFFECT, SCORE_EFFECT);

        HitEffectProcessor processor = new HitEffectProcessor(getVictim(), this);

        processor.setState(new PlayerBeingHit(getVictim()));
        processor.addEffect(effectCheck);

        processor.execute();




        processor.computeDamage();
    }
}
