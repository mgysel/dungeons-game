package test;
import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Boulder;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Portal;
import unsw.dungeon.InteractionStrategyPattern.Treasure;
import unsw.dungeon.Player;

public class TreasureTest {

    @Test
    public void treasureIsLoadedCorrectly() {
        Dungeon d = new Dungeon(5, 5);
        Treasure treasure = new Treasure(d, 2, 2);
        d.addEntity(treasure);
        assertEquals(2, treasure.getY());
        assertEquals(2, treasure.getX());
        assertEquals(1, d.getEntities().size());
    }

    @Test
    public void treasureIsPickedUpByPlayerByMovingIntoSquare() {
        Dungeon d = new Dungeon(5, 5);
        Treasure t = new Treasure(d, 2, 2);
        Player p = new Player(d,1,2);
        d.addEntity(t);
        d.setPlayer(p);
        assertEquals(0,p.getListOfItemsInInventory().size());
        p.moveRight();
        assertEquals(1,p.getListOfItemsInInventory().size());
    }

    @Test
    public void treasureIsRemovedFromDungeon() {
        Dungeon d = new Dungeon(5, 5);
        Treasure t = new Treasure(d, 2, 2);
        Player p = new Player(d,1,2);
        d.addEntity(t);
        d.setPlayer(p);
        for (Entity entity : d.getEntities(2,2)) {
            assert(entity instanceof Treasure);
        }
        p.moveRight();
        for (Entity entity : d.getEntities(2,2)) {
            assert(entity instanceof Player);
        }
    }

}
