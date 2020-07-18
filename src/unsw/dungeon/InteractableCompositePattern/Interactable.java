package unsw.dungeon.InteractableCompositePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Observer;

/**
 * Interactable interface that the interactable objects (floor switch, door, exit, boulder) will inherit from
 * @author Ben Charlton
 */
public interface Interactable {
    public void interactOnDungeon(Dungeon dungeon);
}
