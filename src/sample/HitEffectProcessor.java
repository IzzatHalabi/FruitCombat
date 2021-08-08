package sample;

import sample.Fruits.Fruit;
import sample.PlayerStates.PlayerState;
import sample.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class HitEffectProcessor {

    private Player player;
    private Fruit fruit;

    private PlayerState newState;
    private ArrayList<Integer> effects;

    // EVERY FRUIT HAS DIFFERENT HIT_EFFECTS (FORMULA)
    // EVERY STATE HAS DIFFERENT WAY TO RECEIVE HIT_EFFECTS (MANUAL OF USING THE FORMULA)
    // THEREFORE HIT_EFFECT_PROCESSOR ALLOWS BOTH FORMULA AND MANUAL TO COMMUNICATE

    public HitEffectProcessor(Player player, Fruit fruit) {
        effects = new ArrayList<>();
        this.fruit = fruit;
        this.player = player;
        this.player.getState().bindProcessor(this);
    }

    // TOMATO SET STATE
    // TOMATO SET DAMAGE

    // WATERMELON SET STATE

    public void setState(PlayerState newState) {
        this.newState = newState;
    }

    public void addEffect(ArrayList<Integer> effectCheck) {
        this.effects.addAll(effectCheck);
    }

    public void execute() {

        player.setState(newState, fruit.getHitDuration());
        player.computeDamage(fruit.getDamage());
    }

    public void computeDamage() {
        player.computeDamage(fruit.getDamage());
    }

    public void canGuard() {
        player.getState();
    }

    public void bindState() {

    }
}
