package sample.Model.Moves;

import sample.Model.Fruits.Fruit;

public interface Move {

    void execute();
    void setFruit(Fruit fruit);
    void bind(MoveDataBinder binder);

}
