package unsw.dungeon;

/**  
 * Subject Interface that allows Player, Boulder, Enemies to notify observers of movement
 * @author Mike Gysel
 */
public interface Subject {
    // Register, remove, notify observer functions
    public void registerObserver();
    public void removeObserver();
    public void notifyObservers();
}