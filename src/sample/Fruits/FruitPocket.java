package sample.Fruits;

import sample.Players.Player;
import sample.Position;

import java.util.ArrayList;

import static sample.Config.*;

public class FruitPocket {

    private ArrayList<Fruit> inPocket;
    private ArrayList<Fruit> outPocket;
    private Player player;

    private Position pocketPos;

    private int direction;
    private int throwStart;

    private FruitGroup fruitGroup;

    public FruitPocket(Player player, Position pocketPos) {

        this.player = player;
        this.pocketPos = pocketPos;

        inPocket = new ArrayList<>();
        outPocket = new ArrayList<>();

        if (player.getPlayerNum() == PLAYER_1) {
            direction = MOVE_DIRECTION_RIGHT;
            throwStart = P1_THROW_START;
        } else {
            direction = MOVE_DIRECTION_LEFT;
            throwStart = P2_THROW_START;
        }
    }

    public void deploy(Fruit selectedFruit) {

        if (inPocket.isEmpty()) return;

        int fruitId = inPocket.remove(0).getId();
        selectedFruit.throwInit(fruitId, player.getPos(), direction, throwStart);
        outPocket.add(selectedFruit);
        fruitGroup.getFruitList().set(fruitId, selectedFruit);
    }

    public void returnToStore(Fruit fruit) {

        fruit.setHitOnce(true);
        fruit.setStandBy(true);
        fruit.getPos().setX(pocketPos.getX());
        fruit.getPos().setY(pocketPos.getY());
        inPocket.add(fruit);
    }


    public ArrayList<Fruit> getOutPocket() {
        return outPocket;
    }

    public boolean isOutPocketEmpty() {
        return outPocket.isEmpty();
    }

    public void setFruitGroup(FruitGroup fruitGroup) {
        this.fruitGroup = fruitGroup;
    }
}
