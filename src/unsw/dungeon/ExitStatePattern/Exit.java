package unsw.dungeon.ExitCompositePattern;

public class Exit extends Interactable {

    private ExitState state;

    public Exit() {
        this.state = new ClosedExit();
    }

    public void openExit(ExitState openState) {
        this.state = openState;
    }

    public ExitState getState() {
        return state;
    }


}
