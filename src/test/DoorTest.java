package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.InteractionStrategyPattern.Door;
import unsw.dungeon.InteractionStrategyPattern.Key;


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
        Dungeon dungeon = new Dungeon(10, 10);
        Key key = new Key(1, 2, 3);
        Door door = new Door(2, 2, 3);
        Player player = new Player(dungeon, 0, 2);
        dungeon.addEntity(key);
        dungeon.addEntity(door);
        dungeon.setPlayer(player);
        player.moveRight();
        player.moveRight();
        assert(door.getIsOpen() == true);
    }

    @Test
    public void incorrectKeyDoesNotUnlockDoor() {
        Dungeon dungeon = new Dungeon(10, 10);
        Key key = new Key(1, 2, 2);
        Door door = new Door(2, 2, 3);
        Player player = new Player(dungeon, 0, 2);
        dungeon.addEntity(key);
        dungeon.addEntity(door);
        dungeon.setPlayer(player);
        player.moveRight();
        player.moveRight();
        assert(door.getIsOpen() == false);
    }
}