package unsw.dungeon.ExitCompositePattern;

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
