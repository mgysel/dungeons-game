package unsw.dungeon.ExitStatePattern;

/**
 * OpenExit state for exit
 * @author Ben Charlton
 */
public class OpenExit implements ExitState {

    @Override
    public void openExit(Exit exit) {
        // do nothing
        return;
    }

    @Override
    public void enterExit(Exit exit) {
        //TODO: finish game
    }
}
