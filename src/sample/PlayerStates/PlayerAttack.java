package sample.PlayerStates;

import sample.Players.Player;
import sample.ResponseStates.InactiveResponse;

import static sample.Config.P1_ATTACK;
import static sample.Config.P2_ATTACK;
import static sample.Config.PLAYER_1;

public class PlayerAttack extends PlayerState {

    public PlayerAttack(Player player, int statusTimer) {

        super(player, statusTimer);
        if (player.getPlayerNum() == PLAYER_1) {
            setStatusConfig(P1_ATTACK);
        } else {
            setStatusConfig(P2_ATTACK);
        }
        setResponseState(new InactiveResponse());
    }
}
