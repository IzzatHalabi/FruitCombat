package sample.PlayerStates;

import sample.Fruits.Fruit;
import sample.HitEffectProcessor;
import sample.Players.Player;
import sample.ResponseStates.ActiveResponse;
import sample.ResponseStates.InactiveResponse;

import static sample.Config.*;

public class PlayerGuard extends PlayerState {

    private int guardLevel;

    public PlayerGuard(Player player, int statusTimer) {

        super(player, statusTimer);
        if (player.getPlayerNum() == PLAYER_1) {
            setStatusConfig(P1_GUARD);
        } else {
            setStatusConfig(P2_GUARD);
        }
        setResponseState(new ActiveResponse());

        guardLevel = GUARD_LEVEL_1;
    }

    @Override
    public PlayerState modifyState(Fruit fruit, PlayerState newState) {



//        if (guardLevel > fruit.getAttackLevel()) return this;
//
//        return super.modifyState(fruit, newState);

        return null;
    }

    public void something() {

    }


}
