package sample.Fruits;

import sample.Position;
import sample.State.BeingHitState;

import static sample.Config.*;

public class Tomato extends Fruit {

    public Tomato(int id) {
        super(id);
    }

    public Tomato(int origPosX, int origPosY){
        super(origPosX, origPosY);
    }

    public Tomato(int playerNum, Fruit prevFruit, Position playerPos) {
        super(playerNum, prevFruit, playerPos.getX(), playerPos.getY(),
                TOMATO, TOMATO_DAMAGE, TOMATO_STUN, HIT_FIXED_TIMER);
    }

    @Override
    public void hitEffects(int currentTime) {

        getVictim().setHitPoint(getVictim().getHitPoint() - getDamage());
        getVictim().setStatus(new BeingHitState(getVictim().getPlayerNum(), currentTime, HIT_FIXED_TIMER));
        getVictim().getHighScore().updateScore(DAMAGE_SCORE);
    }
}
