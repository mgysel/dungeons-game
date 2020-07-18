package unsw.dungeon;

public class Sword extends Entity {

    private int usesRemaining = 5;
    private Player playerWieldingSword;

    public Sword(int x, int y) {
        super(x, y);
        this.playerWieldingSword = null;
    }

    public void performInteraction(Player player) {
        playerWieldingSword = player;
        player.addItemToInventory(this);
    }

    public void swingSword() {
        decrementUsesRemaining();
        // kill enemy here?
    }

    public int getUsesRemaining() {
        return usesRemaining;
    }

    private void decrementUsesRemaining(){
        this.usesRemaining--;
        if (getUsesRemaining() == 0) {
            playerWieldingSword.removeItemFromInventory(this);
        }
    }
}
