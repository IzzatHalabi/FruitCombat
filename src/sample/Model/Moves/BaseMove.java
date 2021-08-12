package sample.Model.Moves;

import sample.Model.Fruits.Fruit;

import static sample.Config.Config.PLAYER_HEIGHT;

public abstract class BaseMove implements Move {

    protected Fruit fruit;
    MoveDataBinder binder;
    int speed;

    BaseMove() {}

    BaseMove(int speed) {
        this.speed = speed;
    }

    @Override
    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public void bind(MoveDataBinder binder) {

        this.binder = binder;
        fruit.getPos().setX(binder.player.getPos().getX() + binder.throwStart);
        fruit.getPos().setY(binder.player.getPos().getY() + (PLAYER_HEIGHT/4));
    }
}
