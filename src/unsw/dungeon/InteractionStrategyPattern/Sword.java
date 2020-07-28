package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Entity;
import unsw.dungeon.Player;

public class Sword extends Entity implements Interaction {

    private int usesRemaining = 5;
    private Player playerWieldingSword;

    public Sword(int x, int y) {
        super(x, y);
        this.playerWieldingSword = null;
    }

    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (player.hasSword()) {
                // do nothing
                // only one sword to be picked up at a time
            } else {
                playerWieldingSword = player;
                player.addItemToInventory(this);
                this.doesExist().set(false);
            }
        }
    }

    public int getUsesRemaining() {
        return usesRemaining;
    }

    public void decrementUsesRemaining(){
        this.usesRemaining--;
        if (getUsesRemaining() == 0) {
            playerWieldingSword.removeItemFromInventory(this);
        }
    }
}
