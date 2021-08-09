package sample.Debuffs;

import sample.MainTemp;
import sample.PlayerStates.PlayerBeingHit;
import sample.Players.Player;
import sample.ResponseStates.InactiveResponse;

public class StunDebuff extends BaseDebuff {

    public StunDebuff(Player player, int statusTimer) {
        super(player, statusTimer);
    }

    @Override
    public void execute() {
        getPlayer().setState(new PlayerBeingHit(getPlayer(), getStateTimer()));
    }

    @Override
    public void undo() {

    }

    @Override
    public String info() {
        return "STUN";
    }

    @Override
    public boolean isActive() {
        return getEndTimer() >= MainTemp.time;
    }

    @Override
    public boolean isAllowed() {
        return ! (getPlayer().getState() instanceof PlayerBeingHit);
    }
}
