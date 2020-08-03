package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Treasure;

public class TreasureGoal implements GoalStrategy {

    @Override
    public boolean isComplete(Dungeon dungeon) {
        for (Entity entity : dungeon.getEntities()) {
            if (entity instanceof Treasure) {
                System.out.println("TREASURE GOAL: " + entity.getX() + ", " + entity.getY());
                return false;
            }
        } return true;
    }
}
