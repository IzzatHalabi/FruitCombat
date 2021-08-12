package sample.Model.Moves;

import static sample.Config.Config.FRAME_WIDTH;
import static sample.Config.Config.FRUIT_WIDTH;

public class BidirectionalMove extends BaseMove {

    private boolean firstDirection;

    public BidirectionalMove(int speed) {
        super(speed);
        firstDirection = true;
    }

    @Override
    public void execute() {
        if (firstDirection) {
            fruit.updatePosX( binder.direction * speed);
        } else {
            fruit.updatePosX(-binder.direction * speed);
        }

        if (fruit.getPos().getX() < 0
                || fruit.getPos().getX() + FRUIT_WIDTH > FRAME_WIDTH)
            firstDirection = false;
    }
}
