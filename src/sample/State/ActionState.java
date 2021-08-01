package sample.State;

public abstract class ActionState {

    private int endStatusTimer;
    private int[] statusConfig;

    public ActionState(int currentTimer, int statusTimer) {
        endStatusTimer = currentTimer + statusTimer;
    }

    public boolean isActive(int currentTimer) {
        return endStatusTimer >= currentTimer;
    }

    public int[] getStatusConfig() {
        return statusConfig;
    }

    public void setStatusConfig(int[] statusConfig) {
        this.statusConfig = statusConfig;
    }
}
