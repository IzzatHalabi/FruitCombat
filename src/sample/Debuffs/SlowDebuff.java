package sample.Debuffs;

import sample.Players.Player;

public class SlowDebuff extends BaseDebuff {

    private int slowValue;

    public SlowDebuff(Player player, int stateTimer, int slowValue) {
        super(player, stateTimer);
        this.slowValue = slowValue;
    }

    @Override
    public void execute() {
        getPlayer().reduceSpeed(slowValue);
    }

    @Override
    public void undo() {
        getPlayer().increaseSpeed(slowValue);
    }

    @Override
    public String info() {
        return "SLOW";
    }

    @Override
    public boolean isAllowed() {
        return getPlayer().getFlySpeed() - slowValue > 0;
    }
}
