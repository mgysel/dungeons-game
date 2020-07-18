package unsw.dungeon.ExitStatePattern;

import unsw.dungeon.Exit;
import unsw.dungeon.Player;
/**
 * ClosedExit state for exit
 * @author Ben Charlton
 */
public class ClosedExit implements ExitState {

    @Override
    public void enterExit(Exit exit, Player player) {
        // error message?
        restrictMovementThroughExit(player);
    }

    private void restrictMovementThroughExit(Player player) {
        //TODO
    }

}
