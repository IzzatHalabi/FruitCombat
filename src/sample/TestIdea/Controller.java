package sample.TestIdea;

import sample.Players.PlayerGroup;

public class Controller implements ControllerInterface {

    private PlayerGroup playerGroup;

    public Controller(PlayerGroup playerGroup) {
        this.playerGroup = playerGroup;
    }

    @Override
    public void fly(int playerNum) {
        playerGroup.get(playerNum).getState().fly();
    }

    @Override
    public void attack(int playerNum) {
        playerGroup.get(playerNum).getState().attack();
    }

    @Override
    public void specialAttack(int playerNum) {
        playerGroup.get(playerNum).getState().specialAttack();
    }

    @Override
    public void guard(int playerNum) {

    }
}
