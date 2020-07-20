package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Goal;
import unsw.dungeon.InteractionStrategyPattern.Interaction;
import unsw.dungeon.Player;

/**
 * Exit that players move through when goals completed to finish dungeon
 * @author Ben Charlton
 */
public class Exit extends Entity implements Interaction, Goal {

    private Dungeon dungeon;

    public Exit(Dungeon dungeon, int x, int y) {
        super(x,y);
        this.dungeon = dungeon;
    }

    @Override
    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            if (isComplete()) {
                dungeon.endGame();
            } else {
                // do nothing
            }
        }
    }

    @Override
    public boolean isComplete() {
        if (dungeon.checkNonExitGoalsCompleted()) {
            return true;
        } else {
            return false;
        }
    }

}
