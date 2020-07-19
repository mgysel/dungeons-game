package unsw.dungeon;

public class Treasure extends Entity implements Goal {

    private Dungeon dungeon;

    public Treasure(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
    }

    @Override
    public void performInteraction(Player player) {
        player.addItemToInventory(this);
        dungeon.removeEntity(this);
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