package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.*;
import unsw.dungeon.ObstructionStrategyPattern.Obstruction;
import unsw.dungeon.ObstructionStrategyPattern.Wall;
import unsw.dungeon.LayerEnum;

import java.util.List;

public class Boulder extends Entity implements Obstruction, Interaction {

    private Dungeon dungeon;

    public Boulder(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.viewOrder().set(LayerEnum.ENEMYBOULDER.getZIndex());
        this.viewOrder().set(1.0);
        this.dungeon = dungeon;
    }

    public void move(int x, int y) {
        x().set(x);
        y().set(y);
        for (Entity entity : dungeon.getEntities(x,y)) {
            if (entity instanceof Portal) {
                ((Portal) entity).performInteraction(this);
            }
        }
    }

    @Override
    public boolean isObstruction(Entity entity) {
        System.out.println("1. Is boulder obstruction " + entity);
        if (entity instanceof Player) {
            System.out.println("2. Entity is a player");
            Player player = (Player) entity;
            int playerX = player.getX();
            int playerY = player.getY();
            int thisX = getX();
            int thisY = getY();
            int nextX = (thisX - playerX) + thisX;
            int nextY = (thisY - playerY) + thisY;
            
            List<Entity> xyEntities = dungeon.getEntities(nextX, nextY);
            for (Entity xyEntity : xyEntities) {
                if (xyEntity != null) {
                    System.out.println("3. Going through entities");
                    if (xyEntity instanceof Boulder || xyEntity instanceof Wall || xyEntity instanceof Enemy) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public void performInteraction(Entity entity) {
        int playerX = entity.getX();
        int playerY = entity.getY();
        int thisX = getX();
        int thisY = getY();
        int nextX = (thisX - playerX) + thisX;
        int nextY = (thisY - playerY) + thisY;
        move(nextX, nextY);
    }

}