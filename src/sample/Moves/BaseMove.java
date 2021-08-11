package sample.Moves;

import sample.Fruits.Fruit;

import static sample.Config.PLAYER_HEIGHT;

public abstract class BaseMove implements Move {

    protected int direction;
    protected int throwStart;
    protected Fruit fruit;

    protected int speed;

    protected MoveDataBinder binder;

    public BaseMove() {}

    public BaseMove(int speed) {
        this.speed = speed;
    }

    @Override
    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public void bind(MoveDataBinder binder) {
        this.binder = binder;
        fruit.getPos().setX(binder.getPlayerPos().getX() + binder.throwStart);
        fruit.getPos().setY(binder.getPlayerPos().getY() + (PLAYER_HEIGHT/4));
    }
}
