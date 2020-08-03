package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Player;
import unsw.dungeon.LayerEnum;

public class Treasure extends Entity implements Interaction {

    private Dungeon dungeon;

    public Treasure(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.viewOrder().set(LayerEnum.INVENTORY.getZIndex());
        this.dungeon = dungeon;
    }

    @Override
    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addItemToInventory(this);
        }
    }

}