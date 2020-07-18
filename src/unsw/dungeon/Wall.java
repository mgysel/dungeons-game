package unsw.dungeon;

public class Wall extends Entity implements Obstruction {

    private Dungeon dungeon;

    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isObstruction(Player player) {
        return true;
    }

}
