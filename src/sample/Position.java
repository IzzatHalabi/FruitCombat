package sample;

public class Position {

    private int x;
    private int y;
    private int origX;
    private int origY;


    /////       FUNCTIONS       /////
    public  Position(){}

    public  Position(int x, int y){
        this.x = x;
        this.y = y;
    }


    /////       SETTER AND GETTER       /////
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOrigX() {
        return origX;
    }

    public void setOrigX(int origX) {
        this.origX = origX;
    }

    public int getOrigY() {
        return origY;
    }

    public void setOrigY(int origY) {
        this.origY = origY;
    }
}
