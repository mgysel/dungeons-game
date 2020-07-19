package unsw.dungeon;


import unsw.dungeon.PlayerStatePattern.PlayerState;
import unsw.dungeon.PlayerStatePattern.Vulnerable;

import java.util.ArrayList;
import java.util.List;

/**
 * The player entity
 * 
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity {

    private Dungeon dungeon;
    private ArrayList<Entity> inventory;
    // private PlayerState state;

    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.inventory = new ArrayList<Entity>();
        // this.state = new Vulnerable();
    }

    public void moveUp() {
        int newX = getX();
        int newY = getY() - 1;
        List<Entity> xyEntities = returnEntities(newX, newY);
        if (getY() > 0 && !isObstruction(xyEntities, this)) {
            interact(xyEntities, this);
            y().set(getY() - 1);

        }
    }

    public void moveDown() {
        int newX = getX();
        int newY = getY() + 1;
        List<Entity> xyEntities = returnEntities(newX, newY);
        if ((getY() < dungeon.getHeight() - 1) && (!isObstruction(xyEntities, this)))
            interact(xyEntities, this);
            y().set(getY() + 1);
    }

    public void moveLeft() {
        int newX = getX() - 1;
        int newY = getY();
        List<Entity> xyEntities = returnEntities(newX, newY);
        if (getX() > 0 && !(isObstruction(xyEntities, this)))
            interact(xyEntities, this);
            x().set(getX() - 1);
    }

    public void moveRight() {
        int newX = getX() + 1;
        int newY = getY();
        List<Entity> xyEntities = returnEntities(newX, newY);
        if (getX() < dungeon.getWidth() - 1 && !(isObstruction(xyEntities, this)))
            interact(xyEntities, this);
            x().set(getX() + 1);
    }

    public void addItemToInventory(Entity entity) {
        this.inventory.add(entity);
    }

    public void removeItemFromInventory(Entity entity) {
        this.inventory.remove(entity);
    }

    public ArrayList<Entity> getListOfItemsInInventory() {
        return inventory;
    }

    private List<Entity> returnEntities(int x, int y) {
        List<Entity> entities = dungeon.getEntities();
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

    private boolean isObstruction(List<Entity> xyEntities, Player player) {
        for (Entity entity : xyEntities) {
            System.out.println("ENTITY: " + entity);
            if (entity != null) {
                System.out.println("obstruction? " + entity.isObstruction(player));
                return entity.isObstruction(player);
            }
        }
        return false;
    }

    private void interact(List<Entity> xyEntities, Player player) {
        for (Entity entity : xyEntities) {
            System.out.println("ENTITY: " + entity);
            if (entity != null) {
                System.out.println("obstruction? " + entity.isObstruction(player));
                entity.performInteraction(player);
            }
        }
    }

    public List<Key> getKeyList() {
        List<Key> playerKeyList = new ArrayList<Key>();
        for (Entity entity : inventory) {
            if (entity instanceof Key) {
                playerKeyList.add((Key) entity);
            }
        }
        return playerKeyList;
    }

    public void setPlayerState(PlayerState state) {
        this.state = state;
    }

}
