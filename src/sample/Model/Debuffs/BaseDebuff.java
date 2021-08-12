package sample.Model.Debuffs;

import sample.Starter.MainTemp;
import sample.Model.Players.Player;

public abstract class BaseDebuff implements Debuff {

    private Player player;
    private int stateTimer;
    private int endTimer;

    public BaseDebuff(Player player, int stateTimer) {
        this.player = player;
        this.stateTimer = stateTimer;
        this.endTimer = MainTemp.time + stateTimer;
    }

    @Override
    public boolean isActive() {
        return endTimer >= MainTemp.time;
    }

    // ENCAPSULATIONS
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getEndTimer() {
        return endTimer;
    }

    public int getStateTimer() {
        return stateTimer;
    }
}
