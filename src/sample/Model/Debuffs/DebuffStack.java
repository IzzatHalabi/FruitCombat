package sample.Model.Debuffs;

import java.util.ArrayList;

public class DebuffStack {

    private ArrayList<Debuff> debuffs;

    public DebuffStack() {
        debuffs = new ArrayList<>();
    }

    public void add(Debuff debuff) {
        if (! debuff.isAllowed()) return;
        debuffs.add(debuff);
        debuff.execute();
    }

    public void check() {
        if (debuffs.isEmpty()) return;

        for (int i = debuffs.size() - 1; i >= 0; i--) {

            Debuff debuff = debuffs.get(i);

            if (debuff.isActive()) continue;

            System.out.println("Remove " + debuff.info() + " DEBUFF");

            debuff.undo();
            debuffs.remove(debuff);
        }
    }


    public int count() {
        return debuffs.size();
    }

    public void infoList() {
        for (Debuff debuff : debuffs)
            System.out.println(debuff.info());
    }

}
