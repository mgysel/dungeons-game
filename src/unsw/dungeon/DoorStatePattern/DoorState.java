package unsw.dungeon.DoorStatePattern;

import unsw.dungeon.Door;

/**
 * State interface for door
 * @author Ben Charlton
 */
public interface DoorState {
    void openDoor(Door door);
}
