package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.FloorSwitch;

public class FloorSwitchGoal implements GoalStrategy {

    @Override
    public boolean isComplete(Goal goal) {
    Dungeon dungeon = goal.getDungeon();
		for (Entity entity : dungeon.getEntities()) {
            if (entity instanceof FloorSwitch) {
                if (((FloorSwitch) entity).isComplete()) {
                    continue;
                } else {
                    return false;
                }
            }

        }
		return true;
    }
}
