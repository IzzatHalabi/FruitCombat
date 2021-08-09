package sample.Debuffs;

public interface Debuff {

    void execute();
    void undo();
    String info();
    boolean isActive();
    boolean isAllowed();

}
