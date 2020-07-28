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

    private boolean isOpen;
    private int doorID;

    public Door(int x, int y, int id) {
        super(x,y);
        this.isOpen = false;
        this.doorID = id;
    }

    public int getID() {
        return this.doorID;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public void attemptToUnlockDoorWithKey(Key key) {
        if (key != null) {
            int keyID = key.getID();
            if(keyID == this.doorID) {
                this.isOpen = true;
                this.doesExist().set(false);
                System.out.println("1. Door Open? " + this.isOpen);
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
        System.out.println("2. Door Open? " + this.isOpen);
        for (Key key : player.getKeyList()) {
            if (key.getID() == doorID) {
                return key;
            }
        } return null;
    }


    @Override
    public boolean isObstruction(Player player, int x, int y) {
        if (playerHasKeyForDoor(player) != null || this.isOpen == true) {
            return false;
        } else {
            return true;
        }
    }
}
