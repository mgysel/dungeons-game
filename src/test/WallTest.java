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
        Wall wall = new Wall(1, 1);
        Player player = new Player(dungeon, 0, 1);
        player.moveRight();
        assertEquals(player.getX(), 0);
        assertEquals(player.getY(), 1);
    }
}