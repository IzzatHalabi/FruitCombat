package sample.PlayerStates;

import sample.Players.Player;
import sample.ResponseStates.ActiveResponse;
import sample.ResponseStates.InactiveResponse;

import static sample.Config.*;

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
    public boolean isActive(int currentTimer) {
        return true;
    }
}
