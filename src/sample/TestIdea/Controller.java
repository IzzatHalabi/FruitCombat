package sample.TestIdea;

import sample.MainTemp;
import sample.Players.Player;
import sample.Players.PlayerGroup;

import java.util.ArrayList;

public class Controller implements ControllerInterface {

    private PlayerGroup playerGroup;

    public Controller(PlayerGroup playerGroup) {
        this.playerGroup = playerGroup;
    }

    @Override
    public void fly(int playerNum) {
        playerGroup.get(playerNum).getStatus().fly();
    }

    @Override
    public void attack(int playerNum) {
        playerGroup.get(playerNum).getStatus().attack();
    }

    @Override
    public void specialAttack(int playerNum) {
        playerGroup.get(playerNum).getStatus().specialAttack();
    }

    @Override
    public void guard(int playerNum) {

    }
}
