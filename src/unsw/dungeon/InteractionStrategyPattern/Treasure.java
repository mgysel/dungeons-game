package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Goal;
import unsw.dungeon.Player;

public class Treasure extends Entity implements Goal, Interaction {

    private Dungeon dungeon;

    public Treasure(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
    }

    @Override
    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addItemToInventory(this);
        }
    }

    @Override
    public boolean isComplete() {
        // if the treasure is in the map still
        // then it has not been collected so the goal
        // is not complete
        if (dungeon.getEntities().contains(this)) {
            return false;
        } return true;
    }
}