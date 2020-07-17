package unsw.dungeon.ExitStatePattern;

public interface ExitState {
    void openExit(Exit exit);
    void enterExit(Exit exit);
}
