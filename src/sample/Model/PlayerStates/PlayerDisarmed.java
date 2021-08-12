package sample.Model.PlayerStates;

import sample.Model.Players.Player;
import sample.Model.ResponseStates.DisarmResponse;

import static sample.Config.Config.P1_BEING_HIT;
import static sample.Config.Config.P2_BEING_HIT;
import static sample.Config.Config.PLAYER_1;

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
