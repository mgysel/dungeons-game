/**
 *
 */
package unsw.dungeon;

import unsw.dungeon.GoalCompositePattern.CompositeGoal;
import unsw.dungeon.GoalCompositePattern.Goal;
import unsw.dungeon.GoalCompositePattern.LeafGoal;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Exit;
import unsw.dungeon.ObstructionStrategyPattern.Obstruction;

import java.util.ArrayList;
import java.util.List;

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */
public class Dungeon {

    private int width, height;
    private List<Entity> entities;
    private Goal goal;
    private Player player;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
        if (entity instanceof Enemy) {
            Enemy enemy = (Enemy) entity;
            getPlayer().registerObserver(enemy);
        }
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
        entity.doesExist().set(false);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Entity> getEntities(int x, int y) {
        List<Entity> xyEntities = new ArrayList<Entity>();
        for (Entity entity : entities) {
            if (entity != null) {
                if (entity.getX() == x && entity.getY() == y) {
                    xyEntities.add(entity);
                }
            }
        }
        return xyEntities;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

     public void endGame() {
        this.player = null;
     }


    public boolean isThereObstructionAtXY(int x, int y) {
        for (Entity entity : this.getEntities(x, y) ) {
            if (entity != null && entity instanceof Obstruction) {
                Obstruction obstructingEntity = (Obstruction) entity;
                if (obstructingEntity.isObstruction(getPlayer(), x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void checkGoals() {
        if(goal != null) {
            boolean areGoalsComplete = goal.goalComplete(this);
            if (areGoalsComplete) {
                player.winGame();
            }
        }
    }
}
