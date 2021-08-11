package sample.Moves;

import static sample.Config.FRAME_WIDTH;
import static sample.Config.FRUIT_WIDTH;
import static sample.Config.TOMATO_SPEED;

public class BidirectionalMove extends BaseMove {

    private boolean firstDirection;

    public BidirectionalMove(int speed) {
        super(speed);
        firstDirection = true;
    }

    @Override
    public void execute() {
        if (firstDirection) {
            fruit.updatePosX( binder.direction * TOMATO_SPEED);
        } else {
            fruit.updatePosX(-binder.direction * TOMATO_SPEED);
        }

        if (fruit.getPos().getX() < 0
                || fruit.getPos().getX() + FRUIT_WIDTH > FRAME_WIDTH)
            firstDirection = false;
    }
}
