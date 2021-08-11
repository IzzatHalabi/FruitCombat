package sample.PlayerStates;

import sample.Players.Player;
import sample.ResponseStates.DisarmResponse;

import static sample.Config.P1_BEING_HIT;
import static sample.Config.P2_BEING_HIT;
import static sample.Config.PLAYER_1;

public class PlayerDisarmed extends PlayerState {

    public PlayerDisarmed(Player player, int statusTimer) {
        super(player, statusTimer);
        if (player.getPlayerNum() == PLAYER_1) {
            setStatusConfig(P1_BEING_HIT);
        } else {
            setStatusConfig(P2_BEING_HIT);
        }
        setResponseState(new DisarmResponse());
    }
}
