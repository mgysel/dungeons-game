package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;

/**
 * Test for Player Entity
 */
public class PlayerTest {
    @Test
    public void location() {
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 1, 1);
        assertEquals(player.getX(), 1);
        assertEquals(player.getY(), 1);
    }

    @Test
    public void movement() {
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 1, 1);

        player.moveRight();
        assertEquals(2, player.getX());
        assertEquals(1, player.getY());

        player.moveLeft();
        assertEquals(1, player.getX());
        assertEquals(1, player.getY());

        player.moveDown();
        assertEquals(1, player.getX());
        assertEquals(2, player.getY());

        player.moveUp();
        assertEquals(1, player.getX());
        assertEquals(1, player.getY());
    }
}