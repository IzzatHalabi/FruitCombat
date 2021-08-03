package sample.PlayerStates;

import sample.MainTemp;
import sample.Players.Player;
import sample.ResponseStates.ResponseState;

public abstract class PlayerState {

    private int endStatusTimer;
    private int[] statusConfig;
    private Player player;
    private ResponseState responseState;

    public PlayerState(Player player, int statusTimer) {
        this.player = player;
        endStatusTimer = MainTemp.time + statusTimer;
    }

    public void fly() {
        responseState.fly(player);
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

    public boolean isActive(int currentTimer) {
        return endStatusTimer >= currentTimer;
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
}