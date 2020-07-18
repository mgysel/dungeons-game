/**
 *
 */
package unsw.dungeon;

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

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Entity> getEntities(int x, int y) {
        List<Entity> xyEntities = new ArrayList<Entity>();
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

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    // public boolean checkAllGoalsCompleted() {
    //     for (Goal goal : goals) {
    //         if (goalIsComplete(goal)) {
    //             continue;
    //         } else {
    //             return false;
    //         }
    //     } return true;
    // }

    public Entity getEntityAtPosition(int x, int y) {
        for (Entity entityAtPosition : getEntities()) {
            if (entityAtPosition.getX() == x && entityAtPosition.getY() == y) {
                return entityAtPosition;
            }
        }
        return null;
    }
}
