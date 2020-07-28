package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.InteractionStrategyPattern.Door;
import unsw.dungeon.InteractionStrategyPattern.Key;
import unsw.dungeon.InteractionStrategyPattern.Treasure;


public class DoorTest {
    @Test
    public void location() {
        Door door = new Door(1, 2, 3);
        assertEquals(door.getX(), 1);
        assertEquals(door.getY(), 2);
        assertEquals(door.getID(), 3);
    }

    @Test
    public void DoorIsInitiallyLocked() {
        Door door = new Door(1, 2, 3);
        assert(door.getIsOpen() == false);
    }

    @Test
    public void correctKeyUnlocksDoor() {
        // Setup
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 2);
        Key key = new Key(1, 2, 3);
        Door door = new Door(2, 2, 3);
        dungeon.setPlayer(player);
        dungeon.addEntity(key);
        dungeon.addEntity(door);

        // Must be goal, or player interacting with object ends game
        Treasure treasure = new Treasure(dungeon, 5, 5);
        dungeon.addEntity(treasure);
      //  dungeon.addGoal(treasure);
        
        // Test key/door
        player.moveRight();
        player.moveRight();
        assert(door.getIsOpen() == true);
        player.moveRight();
        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 2);
    }

    @Test
    public void incorrectKeyDoesNotUnlockDoor() {
        // Setup
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 2);
        Key key = new Key(1, 2, 2);
        Door door = new Door(2, 2, 3);
        dungeon.setPlayer(player);
        dungeon.addEntity(key);
        dungeon.addEntity(door);

        // Must be goal, or player interacting with object ends game
        Treasure treasure = new Treasure(dungeon, 5, 5);
        dungeon.addEntity(treasure);
    //    dungeon.addGoal(treasure);

        // Test key/door
        player.moveRight();
        player.moveRight();
        assert(door.getIsOpen() == false);
    }
}