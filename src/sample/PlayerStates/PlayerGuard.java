package sample.PlayerStates;

import sample.Players.Player;
import sample.ResponseStates.InactiveResponse;

import static sample.Config.P1_GUARD;
import static sample.Config.P2_GUARD;
import static sample.Config.PLAYER_1;

public class PlayerGuard extends PlayerState {

    public PlayerGuard(Player player, int statusTimer) {

        super(player, statusTimer);
        if (player.getPlayerNum() == PLAYER_1) {
            setStatusConfig(P1_GUARD);
        } else {
            setStatusConfig(P2_GUARD);
        }
        setResponseState(new InactiveResponse());
    }
}
