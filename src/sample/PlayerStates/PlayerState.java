package sample.PlayerStates;

import sample.Fruits.Fruit;
import sample.HitEffectProcessor;
import sample.Main;
import sample.Players.Player;
import sample.ResponseStates.ResponseState;

public abstract class PlayerState {

    private int endTimer;
    private int[] statusConfig;
    private Player player;
    private ResponseState responseState;
    private HitEffectProcessor processor;

    public PlayerState(Player player) {
        this.player = player;
    }

    public PlayerState(Player player, int statusTimer) {
        this.player = player;
        setEndTimer(statusTimer);
    }

    public PlayerState modifyState(Fruit fruit, PlayerState newState) {
        newState.setEndTimer(fruit.getHitDuration());
        return newState;
    }

    public void bindProcessor(HitEffectProcessor processor) {
        this.processor = processor;
    }

    public void jump() {
        responseState.jump(player);
    }

    public void guard() {
        responseState.guard(player);
    }

    public void attack() {
        responseState.attack(player);
    }

    public void specialAttack() {
        responseState.specialAttack(player);
    }

    public boolean isActive() {
        return endTimer >= Main.time;
    }

    public int[] getStatusConfig() {
        return statusConfig;
    }

    public void setStatusConfig(int[] statusConfig) {
        this.statusConfig = statusConfig;
    }

    public ResponseState getResponseState() {
        return responseState;
    }

    public void setResponseState(ResponseState responseState) {
        this.responseState = responseState;
    }

    public void setEndTimer(int statusTimer) {
        endTimer = Main.time + statusTimer;
    }
}
