package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.FloorSwitch;

public class FloorSwitchGoal implements GoalStrategy {

    @Override
    public boolean isComplete(Dungeon dungeon) {
        for (Entity entity : dungeon.getEntities()) {
            if (entity instanceof FloorSwitch) {
                if (((FloorSwitch) entity).isTriggered()) {
                    continue;
                } else {
                    return false;
                }
            }

        }
        return true;
    }
}
