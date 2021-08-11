package sample.Moves;

import sample.Fruits.Fruit;

public interface Move {

    void execute();
    void setFruit(Fruit fruit);
    void bind(MoveDataBinder binder);

}
