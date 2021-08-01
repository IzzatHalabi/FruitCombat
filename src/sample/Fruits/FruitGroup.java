package sample.Fruits;

import sample.Player;

import java.util.ArrayList;

import static sample.Config.*;
import static sample.Config.FRAME_WIDTH;
import static sample.Config.FRUIT_WIDTH;

public class FruitGroup {



    private int latestId;
    private ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
    private int numFruit;

    public Player[] players;

    public ArrayList<FruitPocket> pockets;

    /////  FUNCTIONS   /////
    public FruitGroup(){}

    public FruitGroup(int test, ArrayList<Player> players) {

        // FruitGroup is universal Fruit, used by FruitPocket.              CLEAR
        // Each Fruit contains unique id, assigned to FruitGroup            CLEAR
        // Each Fruit in FruitGroup will be processed and referenced to FruitPocket CLEAR
        // Assign FruitPocket to each Player


        pockets = new ArrayList<>(2);
        players.get(PLAYER_1).setPocket(pockets.get(PLAYER_1));
        players.get(PLAYER_2).setPocket(pockets.get(PLAYER_2));

        Fruit fruit;

        for (int id = 0; id < TOTAL_NUM_FRUIT; id++) {

            fruit = new Tomato(id);

            if (id < NUM_FRUIT_EACH) {
                pockets.get(PLAYER_1).addFruit(fruit, 20 + id*FRUIT_WIDTH, 45);
            } else {
                pockets.get(PLAYER_2).addFruit(fruit, FRAME_WIDTH - 120 + id*FRUIT_WIDTH, 45);
            }

            fruitList.add(fruit);
        }
    }

    public FruitGroup(Player p1, Player p2){

        for (int i = 0; i < NUM_FRUIT_EACH; i++) {
            add( new Tomato(20 + i * FRUIT_WIDTH, 45) );
            add( new Tomato(FRAME_WIDTH - 120 + i* FRUIT_WIDTH, 45) );
        }
    }

    public void add(Fruit fruit) {
        fruitList.add(fruit);
        numFruit++;
    }

    public void something() {
        for (int i = 0; i < NUM_FRUIT_EACH; i++) {
            if (fruitGroup[PLAYER_1].getFruitList().get(i).isStandBy()) {
                fruitGroup[PLAYER_1].getFruitList().set(i, players.get(PLAYER_1).specialAttack( fruitGroup[PLAYER_1].getFruitList().get(i), time ));
                break;
            }
        }
    }




    //////      SETTER AND GETTER       /////
    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }
}