package sample.Model.Moves;

import sample.Model.Players.Player;
import sample.Model.Players.PlayerGroup;

import java.util.ArrayList;

import static sample.Config.Config.*;
import static sample.Config.Config.P2_THROW_START;

public class MoveDataBinder {

    Player player;
    int direction;
    int throwStart;

    Player victim;

    public MoveDataBinder(Player player) {
        this.player = player;
    }

    public void init() {
        ArrayList<Player> players = PlayerGroup.players;

        if (player.getPlayerNum() == PLAYER_1) {

            direction = MOVE_DIRECTION_RIGHT;
            throwStart = P1_THROW_START;

            victim = players.get(PLAYER_2);

        } else {

            direction = MOVE_DIRECTION_LEFT;
            throwStart = P2_THROW_START;
            victim = players.get(PLAYER_1);

        }
    }

    public Player getVictim() {
        return victim;
    }
}
