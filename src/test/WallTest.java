package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.ObstructionStrategyPattern.Wall;

public class WallTest {
    Dungeon dungeon = new Dungeon(10, 10);

    @Test
    public void location(){
        Wall wall = new Wall(1, 1);
        assertEquals(wall.getX(), 1);
        assertEquals(wall.getY(), 1);
    }

    @Test
    public void blockMovement(){
        // Block right
        Wall wall = new Wall(1, 1);
        dungeon.addEntity(wall);
        Player player = new Player(dungeon, 0, 1);
        player.moveRight();
        assertEquals(player.getX(), 0);
        assertEquals(player.getY(), 1);

        // Block left
        player = new Player(dungeon, 2, 1);
        player.moveLeft();
        assertEquals(player.getX(), 2);
        assertEquals(player.getY(), 1);

        // Block up
        player = new Player(dungeon, 1, 0);
        player.moveUp();
        assertEquals(player.getX(), 1);
        assertEquals(player.getY(), 0);

        // Block down
        player = new Player(dungeon, 1, 2);
        player.moveDown();
        assertEquals(player.getX(), 1);
        assertEquals(player.getY(), 2);
    }
}