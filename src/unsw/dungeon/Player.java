package unsw.dungeon;

import java.util.List;

/**
 * The player entity
 * 
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity {

    private Dungeon dungeon;
    private boolean hasTreasure = false;


    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
    }

    public void moveUp() {
        if (getY() > 0 && !isObstruction(dungeon, getX(), getY()-1))
            y().set(getY() - 1);
        // this.performInteractionForMove();
    }

    /*public void performInteractionForMove() {
        // Entity entity = getEntityAtPosition(currrentX, currentY);
        // Interaction newInteraction = InteractionFactory.getInteractionForEntity(entity);
        // newInteraction.performInteractionOnDungeon(dungeon)
    }*/


    /*
    * Inside the PortalInteraction
    *
    * void performInteractionOnDungeon(dungeon) {
    *       dungeon.setPlayerPosition(newPositon);
    * }
    * */

    public void moveDown() {
        if (getY() < dungeon.getHeight() - 1 && !(isObstruction(dungeon, getX(), getY()+1)))
            y().set(getY() + 1);
    }

    public void moveLeft() {
        if (getX() > 0 && !(isObstruction(dungeon, getX()-1, getY())))
            x().set(getX() - 1);
    }

    public void moveRight() {
        if (getX() < dungeon.getWidth() - 1 && !(isObstruction(dungeon, getX()+1, getY())))
            x().set(getX() + 1);
    }

    private boolean isObstruction(Dungeon dungeon, int x, int y) {
        List<Entity> entities = dungeon.getEntities();
        for (Entity entity : entities) {
            if (entity != null) {
                if (entity.getX() == x && entity.getY() == y && (entity instanceof Wall)) {
                    return true;
                }
            }
        }
        return false;
    }

}
