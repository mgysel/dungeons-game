package unsw.dungeon.GoalCompositePattern;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Enemy;

public class EnemyGoal implements GoalStrategy {

    @Override
    public boolean isComplete(Dungeon dungeon) {
        for (Entity entity : dungeon.getEntities()) {
            if (entity instanceof Enemy) {
                return false;
            }
        } return true;
    }
}
