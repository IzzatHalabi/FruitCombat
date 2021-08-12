package sample.Model.Debuffs;

import sample.Model.PlayerStates.PlayerDisarmed;
import sample.Model.Players.Player;

public class DisarmDebuff extends BaseDebuff {

    public DisarmDebuff(Player player, int stateTimer) {
        super(player, stateTimer);
    }

    @Override
    public void execute() {
        getPlayer().setState(new PlayerDisarmed(getPlayer(), getStateTimer()));
    }

    @Override
    public void undo() {

    }

    @Override
    public String info() {
        return "DISARM";
    }

    @Override
    public boolean isAllowed() {
        return ! (getPlayer().getState() instanceof PlayerDisarmed);
    }
}
