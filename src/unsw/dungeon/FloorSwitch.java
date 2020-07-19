package unsw.dungeon;

public class FloorSwitch extends Entity implements Goal {

    private Dungeon dungeon;

    public FloorSwitch(int x, int y) {
        super(x, y);
    }

    @Override
    public void performInteraction(Player player) {
        // no interaction between player and floor switch
    }


    public boolean isTriggered() {
        for (Entity entity : this.dungeon.getEntities(getX(), getY())) {
            if (entity instanceof Boulder) {
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
