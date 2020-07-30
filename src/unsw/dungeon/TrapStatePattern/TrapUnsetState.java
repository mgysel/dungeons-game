package unsw.dungeon.TrapStatePattern;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Trap;
import unsw.dungeon.Player;

public class TrapUnsetState implements TrapState {

    @Override
    public void performInteraction(Entity entity, Trap trap) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addItemToInventory(trap);
            trap.doesExist().set(false);
        }
    }
}
