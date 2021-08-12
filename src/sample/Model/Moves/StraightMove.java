package sample.Model.Moves;


public class StraightMove extends BaseMove {

    public StraightMove(int speed) {
        super(speed);
    }

    @Override
    public void execute() {
        fruit.updatePosX(binder.direction * speed);
    }
}
