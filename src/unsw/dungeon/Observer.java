package unsw.dungeon;

/**  
 * Observer Interface that allows entities to listen to player, boulder, enemy movements
 * @author Mike Gysel
 */
public interface Observer {
	
	public void update(Subject obj);
	
}