package sample.State;

import static sample.Config.P1_IDLE_FLY;
import static sample.Config.P2_IDLE_FLY;
import static sample.Config.PLAYER_1;

public class IdleFlyState extends ActionState {

    public IdleFlyState(int playerNum, int currentTimer, int statusTimer) {
        super(currentTimer, statusTimer);
        if (playerNum == PLAYER_1) {
            setStatusConfig(P1_IDLE_FLY);
        } else {
            setStatusConfig(P2_IDLE_FLY);
        }
    }

    @Override
    public boolean isActive(int currentTimer) {
        return true;
    }
}
