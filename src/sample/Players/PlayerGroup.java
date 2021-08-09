package sample.Players;

import java.util.ArrayList;

import static sample.Config.*;

public class PlayerGroup {

    private ArrayList<Player> players;

    public PlayerGroup() {

        players = new ArrayList<>();
        players.add( new Player(PLAYER_1, P1_POS_X, GROUND ) );
        players.add( new Player(PLAYER_2, P2_POS_X, GROUND ) );

    }

    public void update(int time) {

        for (Player player : players) {
            player.fall();
            player.checkStatus();
            player.getDebuffs().check();
        }
    }

    public Player get(int id) {
        return players.get(id);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
