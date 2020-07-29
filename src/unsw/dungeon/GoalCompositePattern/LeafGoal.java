package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;

public class LeafGoal implements Goal {
    private GoalStrategy strategy;
    private String name;

    /**
     * Constructor for the goal Leaf takes a string of what goal needs to be achieved and choses the strategy accordingly
     * @param strategy The goal to be achieved
     */
    public LeafGoal(String strategy) {
        name = strategy;
        switch(strategy) {
            case("exit"):
                this.strategy = new ExitGoal();
                break;
            case ("enemies"):
                this.strategy = new EnemyGoal();
                break;
            case("boulders"):
                this.strategy = new FloorSwitchGoal();
                break;
            case("treasure"):
                this.strategy = new TreasureGoal();
                break;
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean goalComplete(Dungeon dungeon) {
        return strategy.isComplete(dungeon);
    }

}
