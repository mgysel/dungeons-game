package test;
import org.json.JSONObject;
import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unsw.dungeon.GoalCompositePattern.Goal;
import unsw.dungeon.GoalCompositePattern.LeafGoal;
import unsw.dungeon.InteractionStrategyPattern.Portal;
import unsw.dungeon.InteractionStrategyPattern.Treasure;
import unsw.dungeon.Player;

public class GoalTest {

    @Test
    public void testSingleGoalNotExit() {
        Dungeon d = new Dungeon(5,5);
        Goal singleGoal = new LeafGoal("treasure");
        d.setGoal(singleGoal);
        Treasure t = new Treasure(d,2,2);
        Player p = new Player(d,3,3);
        d.setPlayer(p);
        d.addEntity(t);
        d.checkGoals();
        assertEquals(d.getPlayer(),p);
        t.performInteraction(p);
        d.checkGoals();
        assertNull(d.getPlayer());
    }

    @Test
    public void testSingleGoalExit() {
    }

    @Test
    public void testCompositeGoalsNotExit() {
    }

    @Test
    public void testCompositeGoalsExit() {
    }

}
