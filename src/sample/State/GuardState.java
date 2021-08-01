package sample.State;

import static sample.Config.P1_GUARD;
import static sample.Config.P2_GUARD;
import static sample.Config.PLAYER_1;

public class GuardState extends ActionState {

    public GuardState(int playerNum, int currentTimer, int statusTimer) {
        super(currentTimer, statusTimer);
        if (playerNum == PLAYER_1) {
            setStatusConfig(P1_GUARD);
        } else {
            setStatusConfig(P2_GUARD);
        }
    }
}
