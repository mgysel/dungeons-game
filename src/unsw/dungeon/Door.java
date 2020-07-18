package unsw.dungeon;

/**
 * Door that players are able to walk through provided it is unlocked
 * or unlock if it is locked
 * @author Ben Charlton
 */
public class Door extends Entity {

    //private DoorState doorState;
    // private int doorID;
    private boolean isOpen;
    private int doorID;
    private int idOfUnlockingKey;

    public Door(int x, int y, int id, int idOfUnlockingKey) {
        super(x,y);
        //this.doorState = new ClosedDoor();
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

    //public void attemptToGoThroughDoorWithPlayer(Player player) {
    //    this.doorState.attemptToGoThroughDoorWithPlayer(this, player); // state pattern
    //}

    //public void setDoorState(DoorState doorState) {
    //    this.doorState = doorState;
    //}

    // @Override
    // public InteractionState getInteractionForEntity() {
    //     return new DoorInteractionState(this);
    // }
}
