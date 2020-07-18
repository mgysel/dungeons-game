package unsw.dungeon.DoorStatePattern;

import unsw.dungeon.Obstruction;
import unsw.dungeon.Player;

/**
 * OpenDoor state for Door
 * 
 * @author Ben Charlton
 */
public class OpenDoor implements DoorState, Obstruction {

    @Override
    public void openDoor(Door door) {

    }

    @Override
    public boolean isObstruction(Player player) {
        return false;
    }


}
