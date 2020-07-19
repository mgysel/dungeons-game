package unsw.dungeon;

public class FloorSwitch extends Entity {

    private Dungeon dungeon;

    public FloorSwitch(int x, int y) {
        super(x, y);
    }

    @Override
    public void performInteraction(Player player) {
        // no interaction between player and floor switch
    }


    public boolean isTriggered(Dungeon dungeon) {
        for (Entity entity : dungeon.getEntities(getX(), getY())) {
            if (entity instanceof Boulder) {
                return true;
            }
        } return false;
    }
}
