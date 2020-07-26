package unsw.dungeon.GoalCompositePattern;

public class OrGoal implements GoalStrategy {

    @Override
    public boolean isComplete(Goal goal) {
        CompositeGoal compositeGoalToCheck = (CompositeGoal) goal;
        for (Goal subGoal : compositeGoalToCheck.getAllSubGoals()) {
            if (!(subGoal.isComplete())) {
                return false;
            }
        }
        return true;
    }
}
