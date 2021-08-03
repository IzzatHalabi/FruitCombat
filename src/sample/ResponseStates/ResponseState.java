package sample.ResponseStates;

import sample.Players.Player;

public interface ResponseState {

    void fly(Player player);
    void guard(Player player);
    void attack(Player player);
    void specialAttack(Player player);

}
