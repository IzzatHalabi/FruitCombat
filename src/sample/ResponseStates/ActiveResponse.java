package sample.ResponseStates;

import sample.Players.Player;

public class ActiveResponse implements ResponseState {

    @Override
    public void jump(Player player) {
        player.jump();
    }

    @Override
    public void guard(Player player) {
        player.guard();
    }

    @Override
    public void attack(Player player) {
        player.attack();
    }

    @Override
    public void specialAttack(Player player) {
        player.specialAttack();
    }
}
