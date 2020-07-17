package unsw.dungeon.ExitStatePattern;

import unsw.dungeon.InteractableCompositePattern.Interactable;

public class Exit extends Interactable {

    private ExitState state;

    public Exit(int x, int y) {
        super(x,y);
        this.state = new ClosedExit();
    }

    public void openExit(ExitState openState) {
        this.state = openState;
    }

    public ExitState getState() {
        return state;
    }


}
