package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.InteractionStrategyPattern.Boulder;

public class BoulderTest {
    // Create new dungeon/boulder
    Dungeon dungeon = new Dungeon(10, 10);

    @Test
    public void boulderLocation(){
        Boulder boulder = new Boulder(dungeon, 1, 1);
        assertEquals(boulder.getX(), 1);
        assertEquals(boulder.getY(), 1);
    }
    
    Player player = new Player(dungeon, 0, 1);

    @Test
    public void pushBoulder(){
        // push boulder right
        Player player = new Player(dungeon, 0, 1);
        Boulder boulder = new Boulder(dungeon, 1, 1);
        player.moveRight();
        assertEquals(boulder.getX(), 2);
        assertEquals(boulder.getY(), 1);

        // push boulder left
        player = new Player(dungeon, 2, 1);
        boulder = new Boulder(dungeon, 1, 1);
        player.moveLeft();
        assertEquals(boulder.getX(), 0);
        assertEquals(boulder.getY(), 1);

        // push boulder up
        player = new Player(dungeon, 1, 0);
        boulder = new Boulder(dungeon, 1, 1);
        player.moveUp();
        assertEquals(boulder.getX(), 1);
        assertEquals(boulder.getY(), 2);

        // push boulder down
        player = new Player(dungeon, 1, 2);
        boulder = new Boulder(dungeon, 1, 1);
        player.moveDown();
        assertEquals(boulder.getX(), 1);
        assertEquals(boulder.getY(), 0);
    }

    @Test
    public void moveBoulderBlocked(){
        player.moveRight();
        // push boulder right
        Player player = new Player(dungeon, 0, 1);
        Boulder boulder = new Boulder(dungeon, 1, 1);
        Boulder boulderBlock = new Boulder(dungeon, 2, 1);
        player.moveRight();
        assertEquals(boulder.getX(), 1);
        assertEquals(boulder.getY(), 1);

        // push boulder left
        player = new Player(dungeon, 2, 1);
        boulder = new Boulder(dungeon, 1, 1);
        boulderBlock = new Boulder(dungeon, 0, 1);
        player.moveLeft();
        assertEquals(boulder.getX(), 1);
        assertEquals(boulder.getY(), 1);

        // push boulder up
        player = new Player(dungeon, 1, 0);
        boulder = new Boulder(dungeon, 1, 1);
        boulderBlock = new Boulder(dungeon, 1, 2);
        player.moveUp();
        assertEquals(boulder.getX(), 1);
        assertEquals(boulder.getY(), 1);

        // push boulder down
        player = new Player(dungeon, 1, 2);
        boulder = new Boulder(dungeon, 1, 1);
        boulderBlock = new Boulder(dungeon, 1, 0);
        player.moveDown();
        assertEquals(boulder.getX(), 1);
        assertEquals(boulder.getY(), 1);
    }
}