package sample.Model.Debuffs;

import sample.Model.PlayerStates.PlayerBeingHit;
import sample.Model.Players.Player;

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
    public boolean isAllowed() {
        return ! (getPlayer().getState() instanceof PlayerBeingHit);
    }
}
