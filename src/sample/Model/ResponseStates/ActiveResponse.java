package sample.Model.ResponseStates;

import sample.Model.Players.Player;

public class ActiveResponse implements ResponseState {

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
        player.attack();
    }

    @Override
    public void specialAttack(Player player) {
        player.specialAttack();
    }
}
