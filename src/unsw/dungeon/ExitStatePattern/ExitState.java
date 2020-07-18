package unsw.dungeon.ExitStatePattern;

import unsw.dungeon.Exit;

/**
 * State interface for 'Exit' class
 * @author Ben Charlton
 */
public interface ExitState {
    void openExit(Exit exit);
    void enterExit(Exit exit);
}
