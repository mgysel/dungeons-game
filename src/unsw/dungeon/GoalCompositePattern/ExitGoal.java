package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Exit;

public class ExitGoal implements GoalStrategy {

    @Override
    public boolean isComplete(Dungeon dungeon) {
        for (Entity entity : dungeon.getEntities()) {
            if (entity instanceof Exit) {
                if (((Exit) entity).isActivated()) {
                    return true;
                }
            }
        } return false;
    }
}
