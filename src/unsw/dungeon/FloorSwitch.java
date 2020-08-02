package unsw.dungeon;

import unsw.dungeon.InteractionStrategyPattern.Boulder;

public class FloorSwitch extends Entity {

    private Dungeon dungeon;
    private boolean triggered;

    public FloorSwitch(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.triggered = false;
    }

    public boolean isTriggered() {
        for (Entity entity : dungeon.getEntities(getX(), getY())) {
            if (entity != null && entity instanceof Boulder) {
                this.triggered = true;
                return true;
            }
        }
        this.triggered = false;
        return false;
    }

}
