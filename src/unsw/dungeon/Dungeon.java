/**
 *
 */
package unsw.dungeon;

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
    private List<Goal> goals;
    private Player player;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
        this.goals = new ArrayList<Goal>();
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
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Entity> getEntities(int x, int y) {
        List<Entity> xyEntities = new ArrayList<Entity>();
        System.out.println("ENTITIES: " + entities);
        for (Entity entity : entities) {
            System.out.println("ENTITY: " + entity);
            if (entity != null) {
                System.out.println("ENTITY: " + entity);
                if (entity.getX() == x && entity.getY() == y) {
                    xyEntities.add(entity);
                }
            }
        }
        return xyEntities;
    }

    public List<Enemy> getEnemies() {
        List<Enemy> enemies = new ArrayList<Enemy>();
        for (Entity entity : entities) {
            if (entity instanceof Enemy) {
                enemies.add((Enemy) entity);
            }
        }
        return enemies;
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

     public void winGame() {
        removeEntity(player);
     }

    public boolean checkNonExitGoalsCompleted() {
        for (Goal goal : goals) {
            if (!(goal instanceof Exit) && goal.isComplete()) {
                continue;
            }
            return false;
        } return true;
    }


    public boolean isThereObstructionAtXY(Player player, int x, int y) {
        for (Entity entity : this.getEntities() ) {
            if (entity != null && entity instanceof Obstruction) {
                Obstruction obstructingEntity = (Obstruction) entity;
                return obstructingEntity.isObstruction(getPlayer(),x, y);
            }
        }
        return false;
    }
}
