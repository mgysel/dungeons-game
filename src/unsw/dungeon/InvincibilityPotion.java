package unsw.dungeon;

import unsw.dungeon.PlayerStatePattern.Invincible;
import unsw.dungeon.PlayerStatePattern.Vulnerable;

import java.util.Timer;
import java.util.TimerTask;

public class InvincibilityPotion extends Entity {

    private Dungeon dungeon;

    public InvincibilityPotion(int x, int y) {
        super(x, y);
    }

    @Override
    public void performInteraction(Player player) {
        player.addItemToInventory(this);
        dungeon.removeEntity(this);
        player.setPlayerState(new Invincible());
        InvincibilityPotion thisPotion = this;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                player.setPlayerState(new Vulnerable());
                player.removeItemFromInventory(thisPotion);
            }
        };
        timer.schedule(task, 1500);
        timer.cancel();
    }
}
