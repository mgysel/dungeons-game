package unsw.dungeon.ExitStatePattern;

/**
 * State interface for 'Exit' class
 * @author Ben Charlton
 */
public interface ExitState {
    void openExit(Exit exit);
    void enterExit(Exit exit);
}
