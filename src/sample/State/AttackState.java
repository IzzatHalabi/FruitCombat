package sample.State;

import static sample.Config.P1_ATTACK;
import static sample.Config.P2_ATTACK;
import static sample.Config.PLAYER_1;

public class AttackState extends ActionState {

    public AttackState(int playerNum, int currentTimer, int statusTimer) {

        super(currentTimer, statusTimer);
        if (playerNum == PLAYER_1) {
            setStatusConfig(P1_ATTACK);
        } else {
            setStatusConfig(P2_ATTACK);
        }
    }
}
