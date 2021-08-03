package sample.PlayerStates;

import sample.Players.Player;
import sample.ResponseStates.InactiveResponse;

import static sample.Config.P1_STUN;
import static sample.Config.P2_STUN;
import static sample.Config.PLAYER_1;

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
