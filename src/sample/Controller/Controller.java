package sample.Controller;

import sample.Players.PlayerGroup;

public class Controller implements ControllerInterface {

    private PlayerGroup playerGroup;

    public Controller(PlayerGroup playerGroup) {
        this.playerGroup = playerGroup;
    }

    @Override
    public void jump(int playerNum) {
        playerGroup.get(playerNum).getState().jump();
    }

    @Override
    public void guard(int playerNum) {
        playerGroup.get(playerNum).getState().guard();
    }

    @Override
    public void attack(int playerNum) {
        playerGroup.get(playerNum).getState().attack();
    }

    @Override
    public void specialAttack(int playerNum) {
        playerGroup.get(playerNum).getState().specialAttack();
    }
}
