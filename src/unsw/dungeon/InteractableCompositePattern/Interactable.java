package unsw.dungeon.InteractableCompositePattern;
import unsw.dungeon.Entity;
import unsw.dungeon.Observer;

/**
 * Interactable abstract class that the interactable objects (floor switch, door, exit) will inherit from
 * @author Ben Charlton
 */
public abstract class Interactable extends Entity implements Observer {

    public int id;

    public Interactable(int x, int y){
        super(x,y);
    }

    public int getID() {
        return id;
    }
}
