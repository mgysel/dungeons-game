package test;
import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import unsw.dungeon.InteractionStrategyPattern.Exit;
import unsw.dungeon.InteractionStrategyPattern.Treasure;
import unsw.dungeon.Player;


public class ExitTest {

    @Test
    public void exitIsLoadedCorrectly() {
        Dungeon d = new Dungeon(5, 5);
        Exit exit = new Exit(d, 2, 2);
        assertEquals(2, exit.getY());
        assertEquals(2, exit.getX());
    }

    @Test
    public void exitDoesNotCompleteGameIfGoalsNotComplete() {
        Dungeon d = new Dungeon(5, 5);
        Exit exit = new Exit(d, 2, 2);
        Treasure t = new Treasure(d,4,4);
        Player p = new Player(d,1,2);
        d.setPlayer(p);
        d.addEntity(t);
        d.addEntity(exit);
      //  d.addGoal(exit);
     //   d.addGoal(t);
        p.moveRight();
        assert(d.getPlayer() != null);
        assertEquals(2,p.getX());
        assertEquals(2,p.getY());
    }

    @Test
    public void exitCompletesGameIfGoalsComplete() {
        Dungeon d = new Dungeon(5, 5);
        Exit exit = new Exit(d, 3, 2);
        Treasure t = new Treasure(d,2,2);
        Player p = new Player(d,1,2);
        d.setPlayer(p);
        d.addEntity(t);
        d.addEntity(exit);
     //   d.addGoal(exit);
     //   d.addGoal(t);
        p.moveRight();
        p.moveRight();
        assert (d.getPlayer() == null);
    }

}
