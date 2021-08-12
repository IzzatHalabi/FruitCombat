package sample.Model.ResponseStates;

import sample.Model.Players.Player;

public class DisarmResponse implements ResponseState {
    @Override
    public void fly(Player player) {
        player.fly();
    }

    @Override
    public void guard(Player player) {
        player.guard();
    }

    @Override
    public void attack(Player player) {

    }

    @Override
    public void specialAttack(Player player) {

    }
}
