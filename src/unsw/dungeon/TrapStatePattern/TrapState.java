package unsw.dungeon.TrapStatePattern;

import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Trap;

public interface TrapState {
    public void performInteraction(Entity entity, Trap trap);
}
