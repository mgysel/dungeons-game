package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;

public class Goal {

    private GoalStrategy strategy;
    private boolean completed;
    private Dungeon dungeon;

    public Goal(Dungeon dungeon, GoalStrategy strategy) {
        this.dungeon = dungeon;
        this.strategy = strategy;
        this.completed = false;
    }

    public boolean isComplete() {
        return this.completed;
    }

    public void completeGoal() {
        this.completed = true;
    }

    public Dungeon getDungeon() {
        return this.dungeon;
    }

}
