package unsw.dungeon.ObstructionStrategyPattern;

import unsw.dungeon.Entity;
import unsw.dungeon.Player;

public interface Obstruction {
    public boolean isObstruction(Entity entity);
}