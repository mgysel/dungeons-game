package unsw.dungeon.ObstructionStrategyPattern;
import unsw.dungeon.Entity;
import unsw.dungeon.Player;

public class Wall extends Entity implements Obstruction {

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isObstruction(Player player, int x, int y) {
        return true;
    }

}
