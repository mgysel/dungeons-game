package unsw.dungeon.DoorStatePattern;

import unsw.dungeon.Obstruction;
import unsw.dungeon.Player;
import unsw.dungeon.Door;

/**
 * ClosedDoor state for Door
 * 
 * @author Ben Charlton
 */
public class ClosedDoor implements DoorState, Obstruction {

    @Override
    public void openDoor(Door door) {
        // if key is held
        // open door
    }

	@Override
	public boolean isObstruction(Player player) {
		// TODO Auto-generated method stub
		return true;
	}
}
