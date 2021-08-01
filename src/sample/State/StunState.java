package sample.State;

import static sample.Config.P1_STUN;
import static sample.Config.P2_STUN;
import static sample.Config.PLAYER_1;

public class StunState extends ActionState {

    public StunState(int playerNum, int currentTimer, int statusTimer) {
        super(currentTimer, statusTimer);
        if (playerNum == PLAYER_1) {
            setStatusConfig(P1_STUN);
        } else {
            setStatusConfig(P2_STUN);
        }
    }
}
