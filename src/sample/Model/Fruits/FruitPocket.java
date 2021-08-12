package sample.Model.Fruits;

import sample.Model.Moves.MoveDataBinder;
import sample.Model.Moves.NoMove;
import sample.Model.Players.Player;
import sample.Model.Position;

import java.util.ArrayList;

public class FruitPocket {

    private ArrayList<Fruit> inPocket;
    private ArrayList<Fruit> outPocket;
    private Player player;

    private Position pocketPos;

    private MoveDataBinder moveDataBinder;

    private FruitGroup fruitGroup;

    public FruitPocket(Player player, Position pocketPos) {

        this.player = player;
        this.pocketPos = pocketPos;

        inPocket = new ArrayList<>();
        outPocket = new ArrayList<>();

        moveDataBinder = new MoveDataBinder(player);
    }

    public void deploy(Fruit fruit) {

        if (inPocket.isEmpty()) return;

        int fruitId = inPocket.remove(0).getId();

        fruit.init(fruitId, moveDataBinder);

        outPocket.add(fruit);

        fruitGroup.getFruitList().set(fruitId, fruit);
    }

    public void returnToStore(Fruit fruit) {

        fruit.setMove(new NoMove());
        fruit.setHitOnce(true);
        fruit.setStandBy(true);
        fruit.getPos().setX(pocketPos.getX());
        fruit.getPos().setY(pocketPos.getY());
        inPocket.add(fruit);
    }

    public void initMoveDataBinder() {
        moveDataBinder.init();
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
