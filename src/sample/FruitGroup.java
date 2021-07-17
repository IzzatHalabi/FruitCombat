package sample;

import java.util.ArrayList;

public class FruitGroup {

     private ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
     private Fruit fruit;
     private int numFruit;


     /////  FUNCTIONS   /////
    public FruitGroup(){}


    public void add(Fruit fruit) {
        fruitList.add(fruit);
        numFruit++;
    }


    //////      SETTER AND GETTER       /////
    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }
}