package sample.Model.PlayerStates;

import sample.Model.Players.Player;
import sample.Model.ResponseStates.ActiveResponse;

import static sample.Config.Config.P1_GUARD;
import static sample.Config.Config.P2_GUARD;
import static sample.Config.Config.PLAYER_1;

public class PlayerGuard extends PlayerState {

    public PlayerGuard(Player player, int statusTimer) {

        super(player, statusTimer);
        if (player.getPlayerNum() == PLAYER_1) {
            setStatusConfig(P1_GUARD);
        } else {
            setStatusConfig(P2_GUARD);
        }
        setResponseState(new ActiveResponse());
    }
}
