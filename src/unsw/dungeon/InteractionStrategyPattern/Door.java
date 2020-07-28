package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Entity;
import unsw.dungeon.ObstructionStrategyPattern.Obstruction;
import unsw.dungeon.Player;

/**
 * Door that players are able to walk through provided it is unlocked
 * or unlock if it is locked
 * @author Ben Charlton
 */
public class Door extends Entity implements Obstruction, Interaction {

    private int doorID;

    public Door(int x, int y, int id) {
        super(x,y);
        this.doorID = id;
    }

    public int getID() {
        return this.doorID;
    }

    public boolean getIsOpen() {
        return this.doesExist().get();
    }

    public void attemptToUnlockDoorWithKey(Key key) {
        if (key != null) {
            int keyID = key.getID();
            if(keyID == this.doorID) {
                this.doesExist().set(false);
            }
        }
    }


    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            System.out.println("Perform Interaction");
            attemptToUnlockDoorWithKey(playerHasKeyForDoor(player));
            player.removeItemFromInventory(playerHasKeyForDoor(player));
        }
    }


    private Key playerHasKeyForDoor(Player player) {
        System.out.println(player);
        for (Key key : player.getKeyList()) {
            if (key.getID() == doorID) {
                return key;
            }
        } return null;
    }


    @Override
    public boolean isObstruction(Player player, int x, int y) {
        if (playerHasKeyForDoor(player) != null || this.doesExist().get() == true) {
            return false;
        } else {
            return true;
        }
    }
}
