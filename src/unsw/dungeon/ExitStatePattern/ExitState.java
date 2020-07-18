package unsw.dungeon.ExitStatePattern;

import unsw.dungeon.Exit;
import unsw.dungeon.Player;

/**
 * State interface for 'Exit' class
 * @author Ben Charlton
 */
public interface ExitState {
    void enterExit(Exit exit, Player player);
}
