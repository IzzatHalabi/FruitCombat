package sample.Model.PlayerStates;

import sample.Model.Players.Player;
import sample.Model.ResponseStates.InactiveResponse;

import static sample.Config.Config.P1_STUN;
import static sample.Config.Config.P2_STUN;
import static sample.Config.Config.PLAYER_1;

public class PlayerStun extends PlayerState {

    public PlayerStun(Player player, int statusTimer) {
        super(player, statusTimer);
        if (player.getPlayerNum() == PLAYER_1) {
            setStatusConfig(P1_STUN);
        } else {
            setStatusConfig(P2_STUN);
        }
        setResponseState(new InactiveResponse());
    }
}
