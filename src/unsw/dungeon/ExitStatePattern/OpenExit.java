package unsw.dungeon.ExitStatePattern;

import unsw.dungeon.Exit;
import unsw.dungeon.Player;

/**
 * OpenExit state for exit
 * @author Ben Charlton
 */
public class OpenExit implements ExitState {

    @Override
    public void enterExit(Exit exit, Player player) {
        finishGame(player);
    }

    private void finishGame(Player player) {
        //TODO
    }
}
