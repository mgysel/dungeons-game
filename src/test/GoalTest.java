package test;
import org.json.JSONObject;
import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unsw.dungeon.FloorSwitch;
import unsw.dungeon.GoalCompositePattern.CompositeGoal;
import unsw.dungeon.GoalCompositePattern.Goal;
import unsw.dungeon.GoalCompositePattern.LeafGoal;
import unsw.dungeon.InteractionStrategyPattern.*;
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
        Dungeon d = new Dungeon(5,5);
        Goal singleGoal = new LeafGoal("exit");
        d.setGoal(singleGoal);
        Exit e = new Exit(d,2,2);
        Player p = new Player(d,3,2);
        d.setPlayer(p);
        d.addEntity(e);
        d.checkGoals();
        assertEquals(d.getPlayer(),p);
        p.moveLeft();
        assertNull(d.getPlayer());
    }

    @Test
    public void testOrGoalsNotExit() {
        Dungeon d = new Dungeon(5,5);
        Player p = new Player(d,3,3);
        d.setPlayer(p);
        Goal treasureGoal = new LeafGoal("treasure");
        Goal enemyGoal = new LeafGoal("boulders");
        CompositeGoal compositeGoal = new CompositeGoal("OR");
        compositeGoal.addGoal(treasureGoal);
        compositeGoal.addGoal(enemyGoal);
        d.setGoal(compositeGoal);
        Treasure t = new Treasure(d,2,2);
        FloorSwitch f = new FloorSwitch(d,5,5);
        d.addEntity(t);
        d.addEntity(f);
        d.checkGoals();
        assertEquals(d.getPlayer(),p);
        t.performInteraction(p);
        d.checkGoals();
        assertNull(d.getPlayer());
        Treasure t2 = new Treasure(d,2,2);
        d.addEntity(t2);
        d.setPlayer(p);
        d.checkGoals();
        assertEquals(d.getPlayer(),p);
        Boulder b = new Boulder(d,5,5);
        d.addEntity(b);
        d.checkGoals();
        assertNull(d.getPlayer());
    }

    @Test
    public void testAndGoalsNotExit() {
        Dungeon d = new Dungeon(5,5);
        Player p = new Player(d,3,3);
        d.setPlayer(p);
        Goal treasureGoal = new LeafGoal("treasure");
        Goal enemyGoal = new LeafGoal("boulders");
        CompositeGoal compositeGoal = new CompositeGoal("AND");
        compositeGoal.addGoal(treasureGoal);
        compositeGoal.addGoal(enemyGoal);
        d.setGoal(compositeGoal);
        Treasure t = new Treasure(d,2,2);
        FloorSwitch f = new FloorSwitch(d,5,5);
        d.addEntity(t);
        d.addEntity(f);
        d.checkGoals();
        assertEquals(d.getPlayer(),p);
        t.performInteraction(p);
        d.checkGoals();
        assertEquals(d.getPlayer(),p);
        Boulder b = new Boulder(d,5,5);
        d.addEntity(b);
        d.checkGoals();
        assertNull(d.getPlayer());
    }

    @Test
    public void testCompositeGoalsFailsWhenIncompleteAtExit() {
        Dungeon d = new Dungeon(5,5);
        Player p = new Player(d,3,1);
        d.setPlayer(p);
        Goal treasureGoal = new LeafGoal("treasure");
        CompositeGoal AndGoal = new CompositeGoal("AND");
        Goal exitGoal = new LeafGoal("exit");
        AndGoal.addGoal(exitGoal);
        AndGoal.addGoal(treasureGoal);
        d.setGoal(AndGoal);
        Treasure t = new Treasure(d,1,1);
        Exit e = new Exit(d,2,1);
        d.addEntity(t);
        d.addEntity(e);
        p.moveLeft();
        assertEquals(d.getPlayer(),p);
        p.moveLeft();
        assertEquals(d.getPlayer(),p);
        p.moveRight();
        assertNull(d.getPlayer());
    }

    @Test
    public void testCompositeGoalsPassWhenCompleteAtExit() {
        Dungeon d = new Dungeon(5,5);
        Player p = new Player(d,2,1);
        d.setPlayer(p);
        Goal treasureGoal = new LeafGoal("treasure");
        Goal enemyGoal = new LeafGoal("boulders");
        CompositeGoal AndGoal = new CompositeGoal("AND");
        CompositeGoal overallGoal = new CompositeGoal("OR");
        Goal exitGoal = new LeafGoal("exit");
        AndGoal.addGoal(treasureGoal);
        AndGoal.addGoal(enemyGoal);
        overallGoal.addGoal(exitGoal);
        overallGoal.addGoal(AndGoal);
        d.setGoal(overallGoal);
        // goal is now either exit OR (boulder AND treasure)
        Treasure t = new Treasure(d,2,2);
        Treasure t2 = new Treasure(d,2,2);
        FloorSwitch f = new FloorSwitch(d,5,5);
        Exit e = new Exit(d,1,1);
        d.addEntity(t);
        d.addEntity(f);
        d.addEntity(e);
        d.checkGoals();
        assertEquals(d.getPlayer(),p);
        p.moveDown();
        Boulder b = new Boulder(d,5,5);
        d.addEntity(b);
        // boulder AND treasure now complete
        d.checkGoals();
        assertNull(d.getPlayer());
        // bring treasure back
        d.addEntity(t2);
        d.setPlayer(p);
        assertEquals(d.getPlayer(),p);
        p.moveLeft();
        p.moveUp();
        // player has moved into exit
        assertNull(d.getPlayer());
    }

}
