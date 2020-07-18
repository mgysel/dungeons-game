<<<<<<< HEAD:src/unsw/dungeon/DoorStatePattern/Door.java
package unsw.dungeon.DoorStatePattern;

=======
package unsw.dungeon;
import unsw.dungeon.DoorStatePattern.ClosedDoor;
import unsw.dungeon.DoorStatePattern.DoorState;
>>>>>>> 26740c3e8ba718784d3994b556cd7b8dacdb44f4:src/unsw/dungeon/Door.java
import unsw.dungeon.InteractableCompositePattern.Interactable;
import unsw.dungeon.Obstruction;
import unsw.dungeon.Subject;

/**
 * Door that players are able to walk through provided it is unlocked
 * or unlock if it is locked
 * @author Ben Charlton
 */
public class Door extends Entity {

    private DoorState state;
    private int doorID;

    public Door(int x, int y, int id) {
        super(x,y);
        this.state = new ClosedDoor();
        this.doorID = id;
    }


    public void openDoor(DoorState openDoor) {
        this.state = openDoor;
    }

    public DoorState getState() {
        return state;
    }

}
