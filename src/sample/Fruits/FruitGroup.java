package sample.Fruits;

import sample.Players.PlayerGroup;
import java.util.ArrayList;
import static sample.Config.*;

public class FruitGroup {

    private ArrayList<Fruit> fruitList;
    private PlayerGroup playerGroup;

    /////  FUNCTIONS   /////
    public FruitGroup(PlayerGroup playerGroup) {

        fruitList = new ArrayList<>();

        this.playerGroup = playerGroup;

        Fruit currentFruit;
        FruitPocket pocket;

        int currentId;

        for (int p = 0; p < NUM_PLAYER; p++) {

            pocket = playerGroup.get(p).getPocket();

            pocket.setFruitGroup(this);

            for (int i = 0; i < NUM_FRUIT_EACH; i++) {

                currentId = i + p*(NUM_FRUIT_EACH);

                currentFruit = new Tomato(currentId);

                pocket.returnToStore(currentFruit);

                fruitList.add(currentFruit);
            }
        }
    }

    public void update(int time) {

        FruitPocket pocket;

        for ( int p = 0; p < NUM_PLAYER; p++ ) {

            pocket = playerGroup.get(p).getPocket();

            if (pocket.isOutPocketEmpty()) continue;

            for (Fruit fruitOutPocket : pocket.getOutPocket()) {

                fruitOutPocket.move();

                if (fruitOutPocket.hitCheck(playerGroup.getPlayers())) {
                    fruitOutPocket.hitEffects(time);
                    pocket.returnToStore(fruitOutPocket);
                }

                if (fruitOutPocket.checkOutOfBound()) {
                    pocket.returnToStore(fruitOutPocket);
                }
            }
        }
    }




    //////      SETTER AND GETTER       /////
    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public Fruit getFruit(int i) {
        return fruitList.get(i);
    }
}