package unsw.dungeon.InteractableCompositePattern;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Observer;

/**
 * Interactable abstract class that the interactable objects (floor switch, door, exit) will inherit from
 * @author Ben Charlton
 */
public interface Interactable {
    public void interactOnDungeon(Dungeon dungeon);
}
