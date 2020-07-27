package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;

public interface GoalStrategy {
    public boolean isComplete(Dungeon dungeon);
}
