package unsw.dungeon.ExitCompositePattern;

public interface ExitState {
    void openExit(Exit exit);
    void enterExit(Exit exit);
}
