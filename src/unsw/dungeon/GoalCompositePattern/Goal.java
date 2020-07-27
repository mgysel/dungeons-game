package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;

public interface Goal {
    public boolean goalComplete(Dungeon dungeon);
}
