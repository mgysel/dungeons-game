package unsw.dungeon.ExitStatePattern;
import unsw.dungeon.InteractableCompositePattern.Interactable;
import unsw.dungeon.Subject;

/**
 * Exit that players move through when goals completed to finish dungeon
 * @author Ben Charlton
 */
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

    @Override
    public void update(Subject obj) {
        //TODO: notify observers when state change
    }

}
