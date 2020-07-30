package unsw.dungeon.TrapStatePattern;

import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Trap;

public class TrapSetState implements TrapState {

    @Override
    public void performInteraction(Entity entity, Trap trap) {
        if (entity instanceof Enemy) {
            Enemy enemy = (Enemy) entity;
            enemy.dies();
            trap.isUsedOnEnemy();
        }
    }
}
