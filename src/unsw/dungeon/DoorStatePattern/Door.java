package unsw.dungeon.DoorStatePattern;
import unsw.dungeon.InteractableCompositePattern.Interactable;

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


}
