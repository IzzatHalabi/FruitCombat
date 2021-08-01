package sample.State;

import static sample.Config.*;

public class IdleGroundState extends ActionState {

    public IdleGroundState(int playerNum, int currentTimer, int statusTimer) {
        super(currentTimer, statusTimer);
        if (playerNum == PLAYER_1) {
            setStatusConfig(P1_IDLE_GROUND);
        } else {
            setStatusConfig(P2_IDLE_GROUND);
        }
    }

    @Override
    public boolean isActive(int currentTimer) {
        return true;
    }
}
