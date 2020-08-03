package unsw.dungeon;

import unsw.dungeon.InteractionStrategyPattern.*;
import unsw.dungeon.ObserverPattern.Subject;
import unsw.dungeon.ObstructionStrategyPattern.Obstruction;
import unsw.dungeon.PlayerStatePattern.PlayerState;
import unsw.dungeon.PlayerStatePattern.Vulnerable;
import unsw.dungeon.LayerEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * The player entity
 * 
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity implements Subject {

    private Dungeon dungeon;
    private ArrayList<Entity> inventory;
    private ArrayList<Enemy> observers;
    private PlayerState state;


    /**
     * Create a player positioned in square (x,y)
     * 
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.viewOrder().set(LayerEnum.PLAYER.getZIndex());
        this.dungeon = dungeon;
        this.inventory = new ArrayList<Entity>();
        this.state = new Vulnerable();
        this.observers = new ArrayList<Enemy>();
    }

    /**
     * Player moves up if not obstruction, interacts with entities
     */
    public void moveUp() {
        int newX = getX();
        int newY = getY() - 1;
        List<Entity> xyEntities = dungeon.getEntities(newX, newY);
        if (getY() > 0 && !dungeon.isThereObstructionAtXY(this, newX, newY)) {
            interact(xyEntities);
            y().set(getY() - 1);
            notifyObservers();
            didIJustFinishGame();
        }
    }

    /**
     * Player moves down if not obstruction, interacts with entities
     */
    public void moveDown() {
        int newX = getX();
        int newY = getY() + 1;
        List<Entity> xyEntities = dungeon.getEntities(newX, newY);
        if ((getY() < dungeon.getHeight() - 1) && (!dungeon.isThereObstructionAtXY(this, newX, newY))) {
            interact(xyEntities);
            y().set(getY() + 1);
            notifyObservers();
            didIJustFinishGame();
        }
    }

    /**
     * Player moves left if not obstruction, interacts with entities
     */
    public void moveLeft() {
        int newX = getX() - 1;
        int newY = getY();
        List<Entity> xyEntities = dungeon.getEntities(newX, newY);
        if (getX() > 0 && !(dungeon.isThereObstructionAtXY(this, newX, newY))) {
            interact(xyEntities);
            x().set(getX() - 1);
            notifyObservers();
            didIJustFinishGame();
        }
    }

    /**
     * Player moves right if not obstruction, interacts with entities
     */
    public void moveRight() {
        int newX = getX() + 1;
        int newY = getY();
        List<Entity> xyEntities = dungeon.getEntities(newX, newY);
        if (getX() < dungeon.getWidth() - 1 && !(dungeon.isThereObstructionAtXY(this, newX, newY))) {
            interact(xyEntities);
            x().set(getX() + 1);
            notifyObservers();
            didIJustFinishGame();
        }
    }

    /**
     * entity added to player inventory, removed from dungeon
     * @param entity
     */
    public void addItemToInventory(Entity entity) {
        this.inventory.add(entity);
        dungeon.removeEntity(entity);
    }

    /**
     * entity removed from player inventory
     * @param entity
     */
    public void removeItemFromInventory(Entity entity) {
        this.inventory.remove(entity);
    }

    /**
     * Returns list of entities in player inventory
     * @return inventory
     */
    public ArrayList<Entity> getListOfItemsInInventory() {
        return inventory;
    }


    /**
     * Player interacts with entities at location (x, y)
     */
    private void interact(List<Entity> xyEntities) {
        Set<Entity> XYEntities = new HashSet<>(xyEntities);
        for (Entity entity : XYEntities) {
            if (entity != null && entity instanceof Interaction) {
                Interaction interactingEntity = (Interaction) entity;
                interactingEntity.performInteraction(this);
            }
        }
        // System.out.println("2.0 Interact");
        // for (Iterator<Entity> it = xyEntities.iterator(); it.hasNext();) {
        //     Entity entity = it.next();
        //     System.out.println("2.1 Interact " + entity);
        //     if (entity != null && entity instanceof Interaction) {
        //         System.out.println("2.2 Interact");
        //         System.out.println("2.2 (X, Y): " + entity.getX() + ", " + entity.getY());
        //         it.remove();
        //         Interaction interactingEntity = (Interaction) entity;
        //         interactingEntity.performInteraction(this);
        //     }
        // }
    }

    /**
     * Returns player key
     * @return
     */
    public List<Key> getKeyList() {
        List<Key> playerKeyList = new ArrayList<Key>();
        for (Entity entity : inventory) {
            if (entity instanceof Key) {
                playerKeyList.add((Key) entity);
            }
        }
        return playerKeyList;
    }

    /**
     * Sets player state
     */
    public void setPlayerState(PlayerState state) {
        this.state = state;
        notifyObservers();
    }

    /**
     * Notifies enemies of location, sword, invincible
     */
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
        // Register observer
        observers.add(e);
    }

    @Override
    public void removeObserver(Enemy e) {
        observers.remove(e);
    }

    public PlayerState getState() {
        return this.state;
    }

    public void removeEnemy(Enemy enemy) {
        removeObserver(enemy);
        enemy.dies();
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
        System.out.println("Did I die?");
        this.doesExist().set(false);
        dungeon.endGame();
    }

    public void winGame() {
        dungeon.endGame();
    }

    /**
     * Determines if player won game with last move
     */
    public void didIJustFinishGame() {
        // If all goals complete, win the game
        dungeon.checkGoals();
    }

    public void setTrap() {
        for (Entity entity : getListOfItemsInInventory()) {
            if (entity instanceof Trap) {
                Trap trapToSet = (Trap) entity;
                trapToSet.x().set(this.getX());
                trapToSet.y().set(this.getY());
                trapToSet.doesExist().set(true);
                trapToSet.changeState();
                break;
            }
        }
    }
}
