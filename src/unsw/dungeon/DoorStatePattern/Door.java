package unsw.dungeon.DoorStatePattern;
import unsw.dungeon.InteractableCompositePattern.Interactable;
import unsw.dungeon.Subject;

/**
 * Door that players are able to walk through provided it is unlocked
 * or unlock if it is locked
 * @author Ben Charlton
 */
public class Door extends Interactable {

    private DoorState state;

    public Door(int x, int y) {
        super(x,y);
        this.state = new ClosedDoor();
    }

    public void openDoor(DoorState openDoor) {
        this.state = openDoor;
    }

    public DoorState getState() {
        return state;
    }


    @Override
    public void update(Subject obj) {
        //TODO: notify observers of state change
    }
}
