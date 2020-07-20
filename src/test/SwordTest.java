package test;
import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Sword;
import unsw.dungeon.InteractionStrategyPattern.Treasure;
import unsw.dungeon.Player;

public class SwordTest {

    @Test
    public void swordIsLoadedCorrectly() {
        Dungeon d = new Dungeon(5, 5);
        Sword s = new Sword(2, 2);
        d.addEntity(s);
        assertEquals(1,d.getEntities().size());
        assertEquals(2, s.getY());
        assertEquals(2, s.getX());
    }

    @Test
    public void playerCanPickUpSword() {
        Dungeon d = new Dungeon(5, 5);
        Sword s = new Sword(2, 2);
        Player p = new Player(d,1,2);
        d.setPlayer(p);
        d.addEntity(s);
        assertEquals(0,p.getListOfItemsInInventory().size());
        assertEquals(1,d.getEntities().size());
        p.moveRight();
        assertEquals(1,p.getListOfItemsInInventory().size());
        assertEquals(0,d.getEntities().size());
    }

    @Test
    public void playerCannotPickUpMoreThanOneSword() {
        Dungeon d = new Dungeon(5, 5);
        Sword s1 = new Sword(2, 2);
        Sword s2 = new Sword(3, 2);
        Player p = new Player(d,1,2);
        d.setPlayer(p);
        d.addEntity(s1);
        d.addEntity(s2);
        assertEquals(0,p.getListOfItemsInInventory().size());
        assertEquals(2,d.getEntities().size());
        p.moveRight();
        assertEquals(1,p.getListOfItemsInInventory().size());
        assertEquals(1,d.getEntities().size());
        p.moveRight();
        assertEquals(1,p.getListOfItemsInInventory().size());
        assertEquals(1,d.getEntities().size());
    }

    @Test
    public void swordKillsEnemyAndLosesUsage() {
        Dungeon d = new Dungeon(5, 5);
        Sword s = new Sword(2, 2);
        Player p = new Player(d,1,2);
        Enemy e = new Enemy(d,5,5);
        d.setPlayer(p);
        d.addEntity(s);
        d.addEntity(e);
        s.performInteraction(p);
        assertEquals(5,s.getUsesRemaining());
        e.performInteraction(p);
        assertEquals(4,s.getUsesRemaining());
        assertEquals(0, d.getEntities().size());
    }

    @Test
    public void swordDisappearsUponDepletion() {
        Dungeon d = new Dungeon(5, 5);
        Sword s = new Sword(2, 2);
        Player p = new Player(d,1,2);
        d.setPlayer(p);
        d.addEntity(s);
        s.performInteraction(p);
        assertEquals(5,s.getUsesRemaining());
        s.decrementUsesRemaining();
        s.decrementUsesRemaining();
        s.decrementUsesRemaining();
        s.decrementUsesRemaining();
        s.decrementUsesRemaining();
        assertEquals(0,p.getListOfItemsInInventory().size());
    }
}