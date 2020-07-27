package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Player;

/**
 * Exit that players move through when goals completed to finish dungeon
 * @author Ben Charlton
 */
public class Exit extends Entity implements Interaction {

    private Dungeon dungeon;
    private boolean activated;

    public Exit(Dungeon dungeon, int x, int y) {
        super(x,y);
        this.dungeon = dungeon;
        this.activated = false;
    }

    @Override
    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            // if all other goals complete
            if (isActivated()) {
                dungeon.endGame();
            } else {
                // do nothing
            }
        }
    }

    public boolean isActivated() {
        // if all other goals completed
        // is activated == true;
        return false;
    }


}
