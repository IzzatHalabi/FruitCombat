package sample.Model.PlayerStates;

import sample.Model.Players.Player;
import sample.Model.ResponseStates.InactiveResponse;

import static sample.Config.Config.P1_ATTACK;
import static sample.Config.Config.P2_ATTACK;
import static sample.Config.Config.PLAYER_1;

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
