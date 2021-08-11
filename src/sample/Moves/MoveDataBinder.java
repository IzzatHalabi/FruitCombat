package sample.Moves;

import sample.Players.Player;
import sample.Players.PlayerGroup;
import sample.Position;

import java.util.ArrayList;

import static sample.Config.*;
import static sample.Config.P2_THROW_START;

public class MoveDataBinder {

    private Player player;
    protected int direction;
    protected int throwStart;
    protected Player victim;

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

    public Position getPlayerPos() {
        return player.getPos();
    }

    public Player getVictim() {
        return victim;
    }
}
