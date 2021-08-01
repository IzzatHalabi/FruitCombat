package sample.State;

import static sample.Config.P1_BEING_HIT;
import static sample.Config.P2_BEING_HIT;
import static sample.Config.PLAYER_1;

public class BeingHitState extends ActionState {

    public BeingHitState(int playerNum, int currentTimer, int statusTimer) {
        super(currentTimer, statusTimer);
        if (playerNum == PLAYER_1) {
            setStatusConfig(P1_BEING_HIT);
        } else {
            setStatusConfig(P2_BEING_HIT);
        }
    }
}
