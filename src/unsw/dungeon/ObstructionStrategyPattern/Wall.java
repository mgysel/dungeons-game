package unsw.dungeon.ObstructionStrategyPattern;
import unsw.dungeon.Entity;
import unsw.dungeon.Player;
import unsw.dungeon.LayerEnum;

public class Wall extends Entity implements Obstruction {

    public Wall(int x, int y) {
        super(x, y);
        this.viewOrder().set(LayerEnum.BOTTOM.getZIndex());
    }

    @Override
    public boolean isObstruction(Player player, int x, int y) {
        return true;
    }

}
