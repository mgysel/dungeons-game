package unsw.dungeon.InteractableCompositePattern;
import org.w3c.dom.Entity;

public abstract class Interactable extends Entity  implements Observer {

    public int id;

    public Interactable(int x, int y){
        super(x,y);
    }

    public int getID() {
        return id;
    }
}
