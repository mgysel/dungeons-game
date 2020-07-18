package unsw.dungeon;

public class Key extends Entity {

    private int keyID;

    public Key(int x, int y, int keyID) {
        super(x, y);
        this.keyID = keyID;
    }

    public int getID() {
        return this.keyID;
    }
}