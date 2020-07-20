package unsw.dungeon;

import unsw.dungeon.InteractionStrategyPattern.Boulder;

public class FloorSwitch extends Entity implements Goal {

    private Dungeon dungeon;

    public FloorSwitch(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
    }

    public boolean isTriggered() {
        System.out.println("ENTITIES: ");
        for (Entity entity : dungeon.getEntities(getX(), getY())) {
            if (entity != null && entity instanceof Boulder) {
                return true;
            }
        } return false;
    }

    @Override
    public boolean isComplete() {
        if (isTriggered()) {
            return true;
        } return false;
    }
}
