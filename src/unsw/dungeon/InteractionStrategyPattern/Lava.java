package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Player;
import unsw.dungeon.LayerEnum;

public class Lava extends Entity implements Interaction {

    public Lava(int x, int y) {
        super(x,y);
        this.viewOrder().set(LayerEnum.BOTTOM.getZIndex());
    }

    @Override
    public void performInteraction(Entity entity) {
        if (entity instanceof Player || entity instanceof Enemy ) {
            this.killEntity(entity);
        }
    }

    private void killEntity(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.dies();
        } else if (entity instanceof Enemy) {
            Enemy enemy = (Enemy) entity;
            enemy.dies();
        }
    }
}


