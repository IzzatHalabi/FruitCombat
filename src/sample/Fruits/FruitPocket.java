package sample.Fruits;

import sample.Player;

import java.util.ArrayList;

public class FruitPocket {

    private ArrayList<Fruit> fruits;
    private Player player;

    public FruitPocket() {

        // FruitGroup is universal Fruit, used by FruitPocket.
        // Each Fruit contains unique id, assigned to FruitGroup
        // Each Fruit in FruitGroup will be processed and referenced to FruitPocket
        // Assign FruitPocket to each Player



    }

    public void addFruit(Fruit fruit, int origPosX, int origPosY) {
        fruit.init(origPosX, origPosY);
        fruits.add(fruit);
    }


}
