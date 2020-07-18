package unsw.dungeon.InteractableCompositePattern;

import unsw.dungeon.Door;
import unsw.dungeon.DoorStatePattern.DoorState;
import unsw.dungeon.DoorStatePattern.OpenDoor;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Portal;

public class DoorInteraction implements Interactable, DoorState {

    private Door door;

    public DoorInteraction(Door door) {
        this.door = door;
    }

    @Override
    public void interactOnDungeon(Dungeon dungeon) {
        // if door is open, do nothing? player has stepped inside
        // if door is closed and player does not have key, stop movement
        // else if door is closed and player has key, open door and allow passage through it
    }

    @Override
    public void openDoor(Door door) {
        // player has key
    }

    private boolean doorIsOpen() {
        if (door.getState() instanceof OpenDoor) {
            return true;
        }
        return false;
    }

    private void preventMovementThroughLockedDoor() {
        // door is locked and player does not have key
    }

}
