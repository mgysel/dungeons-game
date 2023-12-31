package unsw.dungeon.InteractionStrategyPattern;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import unsw.dungeon.Entity;
import unsw.dungeon.ObstructionStrategyPattern.Obstruction;
import unsw.dungeon.Player;
import unsw.dungeon.LayerEnum;

/**
 * Door that players are able to walk through provided it is unlocked
 * or unlock if it is locked
 * @author Ben Charlton
 */
public class Door extends Entity implements Obstruction, Interaction {

    private int doorID;
    public BooleanProperty isOpen;

    public Door(int x, int y, int id) {
        super(x,y);
        this.viewOrder().set(LayerEnum.BOTTOM.getZIndex());
        this.doorID = id;
        this.isOpen = new SimpleBooleanProperty(false);
    }

    public int getID() {
        return this.doorID;
    }

    public boolean getIsOpen() {
        return this.isOpen.get();
    }

    public void attemptToUnlockDoorWithKey(Key key) {
        if (key != null) {
            int keyID = key.getID();
            if(keyID == this.doorID) {
                this.isOpen.set(true);
            }
        }
    }


    public void performInteraction(Entity entity) {
        System.out.println("1. Perform Interaction");
        if (entity instanceof Player) {
            Player player = (Player) entity;
            System.out.println("2. Player");
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
    public boolean isObstruction(Entity entity) {
        if (entity instanceof Player && this.isOpen.get() == false) {
            Player player = (Player) entity;
            if (playerHasKeyForDoor(player) != null) {
                return false;
            } 
            return true;
        } else if (this.isOpen.get() == false) {
            return true;
        }
        return false;
    }
}
