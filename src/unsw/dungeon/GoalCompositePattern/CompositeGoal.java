package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;

import java.util.ArrayList;
import java.util.List;

public class CompositeGoal implements Goal {

    private String composition;
    private List<Goal> goals;

    public CompositeGoal(String operator) {
        goals = new ArrayList<Goal>();
        this.composition = operator;
    }


    public void addGoal(Goal goal) {
        goals.add(goal);
    }


    private boolean isAnd() {
        if (composition.equals("AND")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean goalComplete(Dungeon dungeon) {
        if (goals.size() == 0) {
            return true;
        }
        for(Goal goal: goals) {
            if (isAnd()) {
                if (!goal.goalComplete(dungeon)) {
                    return false;
                }
            } else {
                if (goal.goalComplete(dungeon)) {
                    return true;
                }
            }
        }
        return isAnd();
    }

}
