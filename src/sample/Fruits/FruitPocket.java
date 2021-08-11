package sample.Fruits;

import sample.Moves.MoveDataBinder;
import sample.Moves.NoMove;
import sample.Players.Player;
import sample.Position;

import java.util.ArrayList;

public class FruitPocket {

    private ArrayList<Fruit> inPocket;
    private ArrayList<Fruit> outPocket;
    private Player player;

    private Position pocketPos;

    private int direction;
    private int throwStart;
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

//        System.out.println("IsStandBy? " + fruit.isStandBy());
//        System.out.println("IsHitOnce? " + fruit.isHitOnce());
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
