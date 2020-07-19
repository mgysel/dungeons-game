package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import unsw.dungeon.Dungeon;
import unsw.dungeon.FloorSwitch;
import unsw.dungeon.Player;
import unsw.dungeon.InteractionStrategyPattern.Boulder;
import unsw.dungeon.ObstructionStrategyPattern.Wall;

public class FloorSwitchTest {
    Dungeon dungeon = new Dungeon(10, 10);

    @Test
    public void location(){
        FloorSwitch floorSwitch = new FloorSwitch(1, 1);
        assertEquals(floorSwitch.getX(), 1);
        assertEquals(floorSwitch.getY(), 1);
    }

    @Test
    public void triggered(){
        FloorSwitch floorSwitch = new FloorSwitch(1, 1);
        dungeon.addEntity(floorSwitch);
        assertEquals(floorSwitch.isTriggered(), false);
        // Boulder boulder = new Boulder(dungeon, 1, 1);
        // assertEquals(floorSwitch.isTriggered(), true);
        // boulder.move(2, 1);
        // assertEquals(floorSwitch.isTriggered(), false);
    }
}