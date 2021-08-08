package sample.PlayerStates;

import sample.Players.Player;
import sample.ResponseStates.ActiveResponse;
import sample.ResponseStates.InactiveResponse;

import static sample.Config.P1_IDLE_FLY;
import static sample.Config.P2_IDLE_FLY;
import static sample.Config.PLAYER_1;

public class PlayerIdleFly extends PlayerState {

    public PlayerIdleFly(Player player, int statusTimer) {
        super(player, statusTimer);
        if (player.getPlayerNum() == PLAYER_1) {
            setStatusConfig(P1_IDLE_FLY);
        } else {
            setStatusConfig(P2_IDLE_FLY);
        }
        setResponseState(new ActiveResponse());
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
