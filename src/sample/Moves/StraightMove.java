package sample.Moves;

import static sample.Config.TOMATO_SPEED;

public class StraightMove extends BaseMove {

    public StraightMove(int speed) {
        super(speed);
    }

    @Override
    public void execute() {
        fruit.updatePosX(binder.direction * TOMATO_SPEED);
    }
}
