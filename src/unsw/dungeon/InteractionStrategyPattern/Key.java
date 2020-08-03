package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Entity;
import unsw.dungeon.Player;
import unsw.dungeon.LayerEnum;

public class Key extends Entity implements Interaction {

    private int keyID;

    public Key(int x, int y, int keyID) {
        super(x, y);
        this.viewOrder().set(LayerEnum.BOTTOM.getZIndex());
        this.keyID = keyID;
    }

    public int getID() {
        return this.keyID;
    }

    @Override
    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addItemToInventory(this);
            this.doesExist().set(false);
        }
    }
}