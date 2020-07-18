package unsw.dungeon;
import unsw.dungeon.ExitStatePattern.ClosedExit;
import unsw.dungeon.ExitStatePattern.ExitState;

/**
 * Exit that players move through when goals completed to finish dungeon
 * @author Ben Charlton
 */
public class Exit extends Entity {

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
