package sample.PlayerStates;

import sample.Players.Player;
import sample.ResponseStates.InactiveResponse;

import static sample.Config.P1_BEING_HIT;
import static sample.Config.P2_BEING_HIT;
import static sample.Config.PLAYER_1;

public class PlayerBeingHit extends PlayerState {

    public PlayerBeingHit(Player player, int statusTimer) {
        super(player, statusTimer);
        if (player.getPlayerNum() == PLAYER_1) {
            setStatusConfig(P1_BEING_HIT);
        } else {
            setStatusConfig(P2_BEING_HIT);
        }
        setResponseState(new InactiveResponse());
    }
}
