package unsw.dungeon;

/**
 * Door that players are able to walk through provided it is unlocked
 * or unlock if it is locked
 * @author Ben Charlton
 */
public class Door extends Entity {

    private boolean isOpen;
    private int doorID;
    private int idOfUnlockingKey;

    public Door(int x, int y, int id, int idOfUnlockingKey) {
        super(x,y);
        this.isOpen = false;
        this.doorID = id;
        this.idOfUnlockingKey = idOfUnlockingKey;
    }

    public void attemptToUnlockDoorWithKey(Key key) {
        int keyID = key.getID();
        if(keyID == this.idOfUnlockingKey) {
            this.isOpen = true;
        }
    }


    public void performInteraction(Player player) {
        attemptToUnlockDoorWithKey(playerHasKeyForDoor(player));
        player.removeItemFromInventory(playerHasKeyForDoor(player));
    }


    private Key playerHasKeyForDoor(Player player) {
        for (Key key : player.getKeyList()) {
            if (key.getID() == idOfUnlockingKey) {
                return key;
            }
        } return null;
    }

    public boolean isObstruction(Player player) {
        if (playerHasKeyForDoor(player) == null) {
            return true;
        } else {
            return false;
        }
    }
}
