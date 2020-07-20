package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.*;
import unsw.dungeon.ObstructionStrategyPattern.Obstruction;
import unsw.dungeon.ObstructionStrategyPattern.Wall;

import java.util.List;

public class Boulder extends Entity implements Obstruction, Interaction {

    private Dungeon dungeon;

    public Boulder(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
    }

    public void move(int x, int y) {
        x().set(x);
        y().set(y);
        for (Entity entity : dungeon.getEntities(x,y)) {
            if (entity instanceof Portal) {
                System.out.println("made it");
                ((Portal) entity).performInteraction(this);
            }
        }
    }

    @Override
    public boolean isObstruction(Player player, int x, int y) {
        int playerX = player.getX();
        int playerY = player.getY();
        int thisX = getX();
        int thisY = getY();
        int nextX = (thisX - playerX) + thisX;
        int nextY = (thisY - playerY) + thisY;
        
        List<Entity> xyEntities = dungeon.getEntities(nextX, nextY);
        for (Entity entity : xyEntities) {
            if (entity != null) {
                if (entity instanceof Boulder || entity instanceof Wall) {
                    return true;
                }
            }
        }

        return false;
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