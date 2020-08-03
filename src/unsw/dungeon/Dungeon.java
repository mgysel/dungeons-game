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
        // Register existing enemy observers, start enemy movement
        for (Entity entity : entities) {
            if (entity instanceof Enemy) {
                Enemy thisEnemy = (Enemy) entity;
                player.registerObserver((Enemy) entity);
                thisEnemy.moveEnemy(player, this);
            }
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
        // If player already exists, register observers, start enemy movement
        if (entity instanceof Enemy) {
            Enemy enemy = (Enemy) entity;
            if (getPlayer() != null) {
                getPlayer().registerObserver(enemy);
                enemy.moveEnemy(player, this);
            }
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
        
        this.player.doesExist().set(false);
        this.player = null;
     }


    public boolean isThereObstructionAtXY(Entity entity, int x, int y) {
        for (Entity thisEntity : this.getEntities(x, y) ) {
            if (thisEntity != null && thisEntity instanceof Obstruction) {
                Obstruction obstructingEntity = (Obstruction) thisEntity;
                if (obstructingEntity.isObstruction(entity)) {
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
