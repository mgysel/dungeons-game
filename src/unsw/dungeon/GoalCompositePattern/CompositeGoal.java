package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;

import java.util.ArrayList;

public class CompositeGoal extends Goal {

    private ArrayList<Goal> subGoals;

    public CompositeGoal(Dungeon dungeon, GoalStrategy strategy) {
        super(dungeon, strategy);
        this.subGoals = new ArrayList<Goal>();
    }

    public void addSubGoal(Goal goal) {
        this.subGoals.add(goal);
    }

    public void removeSubGoal(Goal goal) {
        this.subGoals.remove(goal);
    }

    public ArrayList<Goal> getAllSubGoals() {
        return this.subGoals;
    }

    public ArrayList<Goal> getIncompleteGoals() {
        ArrayList<Goal> incompleteGoals = new ArrayList<Goal>();
        for (Goal goal : this.subGoals) {
            if (!goal.isComplete()) {
                incompleteGoals.add(goal);
            }
        }
        return incompleteGoals;
    }
}
