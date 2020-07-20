package test;

import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unsw.dungeon.Entity;
import unsw.dungeon.FloorSwitch;
import unsw.dungeon.InteractionStrategyPattern.Boulder;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.InvincibilityPotion;
import unsw.dungeon.InteractionStrategyPattern.Portal;
import unsw.dungeon.InteractionStrategyPattern.Treasure;
import unsw.dungeon.Player;

public class GoalTest {
    @Test
    public void goalsComplete() {
        Dungeon dungeon = new Dungeon(10, 10);
        Treasure treasure = new Treasure(dungeon, 1, 0);
        Player player = new Player(dungeon, 0, 0);
        dungeon.setPlayer(player);
        dungeon.addEntity(treasure);
        dungeon.addGoal(treasure);
        player.moveRight();

        assertEquals(null, player);

        

    }
}