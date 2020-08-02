package test;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import unsw.dungeon.Bomb;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.InteractionStrategyPattern.Enemy;

public class BombTest {
    
    @Test
    public void location() {
        Dungeon dungeon = new Dungeon(10, 10);
        Bomb bomb = new Bomb(dungeon, 1, 2);
        dungeon.addEntity(bomb);
        assertEquals(bomb.getX(), 1);
        assertEquals(bomb.getY(), 2);
    }

}