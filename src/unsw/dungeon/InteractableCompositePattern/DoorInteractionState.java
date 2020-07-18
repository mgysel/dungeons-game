package unsw.dungeon.InteractableCompositePattern;

import unsw.dungeon.Door;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Key;

import java.util.List;

public class DoorInteractionState implements InteractionState {

    private Door door;

    public DoorInteractionState(Door door) {
        this.door = door;
    }

    @Override
    public void interactOnDungeon(Dungeon dungeon) {
        List<Key> keyListForPlayer = dungeon.getPlayer().getKeyList();
        for(Key key : keyListForPlayer) {
            this.door.attemptToUnlockDoorWithKey(key);
        }
        if(this.door.isOpen()) {
            // Set new player coords
        } else {
            // keep player here or something
        }
    }
}
