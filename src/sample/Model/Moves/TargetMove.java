package sample.Model.Moves;

import sample.Model.Position;

import static sample.Config.Config.PLAYER_1;

public class TargetMove extends BaseMove {

    private int speedX, speedY;
    private boolean hasCalculate;

    public TargetMove(int speed) {

        super(speed);
        hasCalculate = false;
    }

    @Override
    public void execute() {

        if (! hasCalculate) {

            performCalculation();

            return;
        }

        fruit.updatePosX(binder.direction * speed);
        fruit.updatePosY(binder.direction * speedY);
    }

    private void performCalculation() {

        hasCalculate = true;

        Position playerPos = binder.player.getPos();
        Position victimPos = binder.victim.getPos();

        if (binder.player.getPlayerNum() == PLAYER_1) {

            calculateSpeed(victimPos, playerPos);

        } else {

            calculateSpeed(playerPos, victimPos);

        }
        speedY = speed * speedY / speedX;
    }

    private void calculateSpeed(Position pos1, Position pos2) {

        speedX = pos1.getX() - pos2.getX();
        speedY = pos1.getY() - pos2.getY();
    }
}
