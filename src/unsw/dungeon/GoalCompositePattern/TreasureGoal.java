package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Treasure;

public class TreasureGoal implements GoalStrategy {

    @Override
    public boolean isComplete(Goal goal) {
        Dungeon dungeon = goal.getDungeon();
        for (Entity entity : dungeon.getEntities()) {
            if (entity instanceof Treasure) {
                return false;
            }
        } return true;
    }

}
