package unsw.dungeon.ObserverPattern;

import unsw.dungeon.InteractionStrategyPattern.Enemy;

/**
 * Subject Interface that allows Player, Boulder, Enemies to notify observers of movement
 * @author Mike Gysel
 */
public interface Subject {
    // Register, remove, notify observer functions
    public void registerObserver(Enemy e);
    public void removeObserver(Enemy e);
    public void notifyObservers();
}