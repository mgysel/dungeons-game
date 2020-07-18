package unsw.dungeon;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.dungeon.InteractableCompositePattern.InteractionState;
import unsw.dungeon.InteractableCompositePattern.PortalInteractionState;
// import unsw.dungeon.Dungeon;
// import unsw.dungeon.Subject;

public class Portal extends Entity {

    private IntegerProperty exitXCoordinate;
    private IntegerProperty exitYCoordinate;

    public Portal(int x, int y) {
        super(x, y);
    }

    @Override
    public InteractionState getInteractionForEntity() {
        return new PortalInteractionState(this);
    }

    public void setExitCoordinates(int x, int y) {
        this.exitXCoordinate = new SimpleIntegerProperty(x);
        this.exitYCoordinate = new SimpleIntegerProperty(y);
    }

    public IntegerProperty getExitXCoordinate() {
        return exitXCoordinate;
    }

    public IntegerProperty getExitYCoordinate() {
        return exitYCoordinate;
    }
}
