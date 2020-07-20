package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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

    @Test
    public void nonPlayerDoesntBreakGame(){
        Dungeon dungeon = new Dungeon(10, 10);
        Boulder boulder = new Boulder(dungeon, 1, 1);
        Boulder boulder2 = new Boulder(dungeon, 2, 1);
        dungeon.addEntity(boulder);
        dungeon.addEntity(boulder2);
        boulder.performInteraction(boulder2);
        assertEquals(2, boulder2.getX());
        assertEquals(1, boulder2.getY());
        assertEquals(1, boulder.getX());
        assertEquals(1, boulder.getY());
    }

    @Test
    public void pushBoulder(){
        // push boulder right
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 1);
        Boulder boulder = new Boulder(dungeon, 1, 1);
        dungeon.setPlayer(player);
        dungeon.addEntity(boulder);
        player.moveRight();
        assertEquals(2, boulder.getX());
        assertEquals(1, boulder.getY());

        // push boulder left
        dungeon = new Dungeon(10, 10);
        player = new Player(dungeon, 2, 1);
        boulder = new Boulder(dungeon, 1, 1);
        dungeon.setPlayer(player);
        dungeon.addEntity(boulder);
        player.moveLeft();
        assertEquals(0, boulder.getX());
        assertEquals(1, boulder.getY());

        // push boulder down
        dungeon = new Dungeon(10, 10);
        player = new Player(dungeon, 1, 0);
        boulder = new Boulder(dungeon, 1, 1);
        dungeon.setPlayer(player);
        dungeon.addEntity(boulder);
        player.moveDown();
        assertEquals(1, boulder.getX());
        assertEquals(2, boulder.getY());

        // push boulder up
        dungeon = new Dungeon(10, 10);
        player = new Player(dungeon, 1, 2);
        boulder = new Boulder(dungeon, 1, 1);
        dungeon.setPlayer(player);
        dungeon.addEntity(boulder);
        player.moveUp();
        assertEquals(1, boulder.getX());
        assertEquals(0, boulder.getY());
    }

    @Test
    public void moveBoulderBlocked(){
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 1);
        Boulder boulder = new Boulder(dungeon, 1, 1);
        Boulder boulderBlock = new Boulder(dungeon, 2, 1);
        dungeon.setPlayer(player);
        dungeon.addEntity(boulder);
        dungeon.addEntity(boulderBlock);
        player.moveRight();
        assertEquals(1, boulder.getX());
        assertEquals(1, boulder.getY());

        // push boulder left
        dungeon = new Dungeon(10, 10);
        player = new Player(dungeon, 2, 1);
        boulder = new Boulder(dungeon, 1, 1);
        boulderBlock = new Boulder(dungeon, 0, 1);
        dungeon.setPlayer(player);
        dungeon.addEntity(boulder);
        dungeon.addEntity(boulderBlock);
        player.moveLeft();
        assertEquals(1, boulder.getX());
        assertEquals(1, boulder.getY());

        // push boulder down
        dungeon = new Dungeon(10, 10);
        player = new Player(dungeon, 1, 0);
        boulder = new Boulder(dungeon, 1, 1);
        boulderBlock = new Boulder(dungeon, 1, 2);
        dungeon.setPlayer(player);
        dungeon.addEntity(boulder);
        dungeon.addEntity(boulderBlock);
        player.moveDown();
        assertEquals(1, boulder.getX());
        assertEquals(1, boulder.getY());

        // push boulder up
        dungeon = new Dungeon(10, 10);
        player = new Player(dungeon, 1, 2);
        boulder = new Boulder(dungeon, 1, 1);
        boulderBlock = new Boulder(dungeon, 1, 0);
        dungeon.setPlayer(player);
        dungeon.addEntity(boulder);
        dungeon.addEntity(boulderBlock);
        player.moveUp();
        assertEquals(1, boulder.getX());
        assertEquals(1, boulder.getY());
    }
}