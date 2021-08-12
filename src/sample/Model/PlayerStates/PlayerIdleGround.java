package sample.Model.PlayerStates;

import sample.Model.Players.Player;
import sample.Model.ResponseStates.ActiveResponse;

import static sample.Config.Config.*;

public class PlayerIdleGround extends PlayerState {

    public PlayerIdleGround(Player player, int statusTimer) {
        super(player, statusTimer);
        if (player.getPlayerNum() == PLAYER_1) {
            setStatusConfig(P1_IDLE_GROUND);
        } else {
            setStatusConfig(P2_IDLE_GROUND);
        }
        setResponseState(new ActiveResponse());
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
