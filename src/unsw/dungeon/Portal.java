package unsw.dungeon;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
// import unsw.dungeon.Dungeon;
// import unsw.dungeon.Subject;

public class Portal extends Entity {

    private IntegerProperty exitXCoordinate;
    private IntegerProperty exitYCoordinate;

    public Portal(int x, int y) {
        super(x, y);
    }

    public void setExitCoordinates(int x, int y) {
        this.exitXCoordinate = new SimpleIntegerProperty(x);
        this.exitYCoordinate = new SimpleIntegerProperty(y);
    }

    public int getExitXCoordinate() {
        return exitXCoordinate.get();
    }

    public int getExitYCoordinate() {
        return exitYCoordinate.get();
    }

    public void performInteraction(Player player) {
        // move player to corresponding portal
        // need to ensure player doesnt move from this after 'interact' is called
        // fix logic inside player
        movePlayerToCorrespondingPortal(player);
    }

    private void movePlayerToCorrespondingPortal(Player player) {
        int xToMoveTo = getExitXCoordinate();
        int yToMoveTo = getExitYCoordinate();
        player.y().set(yToMoveTo);
        player.x().set(xToMoveTo);
    }

}
