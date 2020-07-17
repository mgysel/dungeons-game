package unsw.dungeon.ExitStatePattern;

/**
 * ClosedExit state for exit
 * @author Ben Charlton
 */
public class ClosedExit implements ExitState {

    @Override
    public void openExit(Exit exit) {
        exit.openExit(new OpenExit());
    }

    @Override
    public void enterExit(Exit exit) {
        // error message?
        // do nothing?
    }


}
