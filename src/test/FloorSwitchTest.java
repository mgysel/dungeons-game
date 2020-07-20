package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unsw.dungeon.Dungeon;
import unsw.dungeon.FloorSwitch;
import unsw.dungeon.InteractionStrategyPattern.Boulder;

public class FloorSwitchTest {

    @Test
    public void location(){
        Dungeon dungeon = new Dungeon(10, 10);
        FloorSwitch floorSwitch = new FloorSwitch(dungeon, 1, 1);
        assertEquals(floorSwitch.getX(), 1);
        assertEquals(floorSwitch.getY(), 1);
    }

    @Test
    public void triggered(){
        Dungeon dungeon = new Dungeon(10, 10);
        FloorSwitch floorSwitch = new FloorSwitch(dungeon, 2, 1);
        dungeon.addEntity(floorSwitch);
        assertEquals(floorSwitch.isTriggered(), false);
        Boulder boulder = new Boulder(dungeon, 1, 1);
        dungeon.addEntity(boulder);
        boulder.move(2, 1);
        assertEquals(floorSwitch.isTriggered(), true);
        boulder.move(3, 1);
        assertEquals(floorSwitch.isTriggered(), false);
    }
}