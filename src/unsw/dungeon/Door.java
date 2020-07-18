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

    public boolean isOpen() {
        return this.isOpen;
    }

    public void performInteraction(Player player) {
        if (isOpen()) {
            moveThroughDoor(player);
        } else {
            if (playerHasKeyForDoor(player) != null) {
                attemptToUnlockDoorWithKey(playerHasKeyForDoor(player));
                moveThroughDoor(player);
            } else {
                preventPassageThroughDoor(player);
            }
        }
    }

    private void preventPassageThroughDoor(Player player) {

    }

    private void moveThroughDoor(Player player) {

    }

    private Key playerHasKeyForDoor(Player player) {
        for (Key key : player.getKeyList()) {
            if (key.getID() == idOfUnlockingKey) {
                return key;
            }
        } return null;
    }
}
