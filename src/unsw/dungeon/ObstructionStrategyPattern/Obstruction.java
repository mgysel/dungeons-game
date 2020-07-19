package unsw.dungeon.ObstructionStrategyPattern;
import unsw.dungeon.Player;

public interface Obstruction {
    public boolean isObstruction(Player player, int x, int y);
}