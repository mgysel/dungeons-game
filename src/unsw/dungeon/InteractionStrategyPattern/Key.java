package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Entity;
import unsw.dungeon.Player;

public class Key extends Entity implements Interaction {

    private int keyID;

    public Key(int x, int y, int keyID) {
        super(x, y);
        this.keyID = keyID;
    }

    public int getID() {
        return this.keyID;
    }

    @Override
    public void performInteraction(Player player) {
        player.addItemToInventory(this);
    }
}