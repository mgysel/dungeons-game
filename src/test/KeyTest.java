package test;

import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import unsw.dungeon.InteractionStrategyPattern.Key;
import unsw.dungeon.Player;

public class KeyTest {

    @Test
    public void location() {
        Key key = new Key(1, 2, 3);
        assertEquals(key.getX(), 1);
        assertEquals(key.getY(), 2);
        assertEquals(key.getID(), 3);
    }

    @Test
    public void keyIsPickedUpByPlayer() {
        Dungeon dungeon = new Dungeon(10, 10);
        Key key = new Key(1, 2, 3);
        Player player = new Player(dungeon, 2, 2);
        dungeon.addEntity(key);
        dungeon.setPlayer(player);
        player.moveLeft();
        assert(player.getListOfItemsInInventory().contains(key));
    }

    @Test
    public void keyIsRemovedFromDungeon() {
        Dungeon dungeon = new Dungeon(10, 10);
        Key key = new Key(1, 2, 3);
        Player player = new Player(dungeon, 2, 2);
        dungeon.addEntity(key);
        dungeon.setPlayer(player);
        player.moveLeft();
        assert(!dungeon.getEntities().contains(key));
    }

    @Test
    public void playerCannotPickupTwoKeys() {
        Dungeon dungeon = new Dungeon(10, 10);
        Key key = new Key(1, 2, 3);
        Key keyTwo = new Key(0, 2, 3);
        Player player = new Player(dungeon, 2, 2);
        dungeon.addEntity(key);
        dungeon.setPlayer(player);
        player.moveLeft();
        player.moveLeft();
        assert(player.getListOfItemsInInventory().contains(key));
        assert(!player.getListOfItemsInInventory().contains(keyTwo));
    }

}