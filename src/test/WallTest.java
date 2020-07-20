package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.ObstructionStrategyPattern.Wall;

public class WallTest {
    @Test
    public void location(){
        Wall wall = new Wall(1, 1);
        assertEquals(wall.getX(), 1);
        assertEquals(wall.getY(), 1);
    }

    @Test
    public void blockMovement(){
        // Block right
        Dungeon dungeon = new Dungeon(10, 10);
        Wall wall = new Wall(1, 1);
        dungeon.addEntity(wall);
        Player player = new Player(dungeon, 0, 1);
        dungeon.setPlayer(player);
        player.moveRight();
        assertEquals(0, player.getX());
        assertEquals(1, player.getY());

        // Block left
        dungeon = new Dungeon(10, 10);
        wall = new Wall(1, 1);
        dungeon.addEntity(wall);
        player = new Player(dungeon, 2, 1);
        dungeon.setPlayer(player);
        player.moveLeft();
        assertEquals(2, player.getX());
        assertEquals(1, player.getY());

        // Block down
        dungeon = new Dungeon(10, 10);
        wall = new Wall(1, 1);
        dungeon.addEntity(wall);
        player = new Player(dungeon, 1, 0);
        dungeon.setPlayer(player);
        player.moveDown();
        assertEquals(1, player.getX());
        assertEquals(0, player.getY());

        // Block up
        dungeon = new Dungeon(10, 10);
        wall = new Wall(1, 1);
        dungeon.addEntity(wall);
        player = new Player(dungeon, 1, 2);
        dungeon.setPlayer(player);
        player.moveUp();
        assertEquals(1, player.getX());
        assertEquals(2, player.getY());
    }
}