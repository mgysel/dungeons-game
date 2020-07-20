package unsw.dungeon;

import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Interaction;
import unsw.dungeon.InteractionStrategyPattern.Key;
import unsw.dungeon.InteractionStrategyPattern.Sword;
import unsw.dungeon.ObserverPattern.Subject;
import unsw.dungeon.ObstructionStrategyPattern.Obstruction;
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
public class Player extends Entity implements Subject {

    private Dungeon dungeon;
    private ArrayList<Entity> inventory;
    private List<Enemy> observers;
    private PlayerState state;


    /**
     * Create a player positioned in square (x,y)
     * 
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.inventory = new ArrayList<Entity>();
        this.state = new Vulnerable();
    }

    public void moveUp() {
        int newX = getX();
        int newY = getY() - 1;
        List<Entity> xyEntities = returnEntities(newX, newY);
        if (getY() > 0 && !dungeon.isThereObstructionAtXY(this, newX, newY)) {
            interact(xyEntities, this);
            y().set(getY() - 1);
            notifyObservers();
        }
    }

    public void moveDown() {
        int newX = getX();
        int newY = getY() + 1;
        List<Entity> xyEntities = returnEntities(newX, newY);
        if ((getY() < dungeon.getHeight() - 1) && (!dungeon.isThereObstructionAtXY(this, newX, newY))) {
            interact(xyEntities, this);
            y().set(getY() + 1);
            notifyObservers();
        }
    }

    public void moveLeft() {
        int newX = getX() - 1;
        int newY = getY();
        List<Entity> xyEntities = returnEntities(newX, newY);
        if (getX() > 0 && !(dungeon.isThereObstructionAtXY(this, newX,newY))) {
            interact(xyEntities, this);
            x().set(getX() - 1);
            notifyObservers();
        }
    }

    public void moveRight() {
        int newX = getX() + 1;
        int newY = getY();
        List<Entity> xyEntities = returnEntities(newX, newY);
        if (getX() < dungeon.getWidth() - 1 && !(dungeon.isThereObstructionAtXY(this, newX, newY))) {
            interact(xyEntities, this);
            x().set(getX() + 1);
            notifyObservers();
        }
    }

    public void addItemToInventory(Entity entity) {
        this.inventory.add(entity);
        dungeon.removeEntity(entity);
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

    private void interact(List<Entity> xyEntities, Player player) {
        for (Entity entity : xyEntities) {
            System.out.println("ENTITY: " + entity);
            if (entity != null && entity instanceof Interaction) {
                Interaction interactingEntity = (Interaction) entity;
                interactingEntity.performInteraction(player);
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
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        if (observers != null) {
            for (Enemy o : observers) {
                o.update(this);
            }
        }
    }

    @Override
    public void registerObserver(Enemy e) {
        // Register all enemies
        observers = dungeon.getEnemies();
    }

    @Override
    public void removeObserver(Enemy e) {
        observers.remove(e);
    }

    public PlayerState getState() {
        return this.state;
    }

    public void removeEnemy(Enemy enemy) {
        dungeon.removeEntity(enemy);
    }

    public void swingSword(Enemy enemy) {
        for (Entity entity : getListOfItemsInInventory()) {
            if (entity instanceof Sword) {
                Sword sword = (Sword) entity;
                sword.decrementUsesRemaining();
                removeEnemy(enemy);
            }
        }
    }

    public boolean hasSword() {
        for (Entity entity : getListOfItemsInInventory()) {
            if (entity instanceof Sword) {
                return true;
            }
        } return false;
    }

    public void dies() {
        dungeon.removeEntity(this);
    }
}
