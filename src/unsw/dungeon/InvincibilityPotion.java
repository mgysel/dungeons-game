package unsw.dungeon;

import unsw.dungeon.PlayerStatePattern.Invincible;
import unsw.dungeon.PlayerStatePattern.Vulnerable;

import java.util.Timer;
import java.util.TimerTask;

public class InvincibilityPotion extends Entity {

    public InvincibilityPotion(int x, int y) {
        super(x, y);
    }

    @Override
    public void performInteraction(Player player) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                player.setPlayerState(new Invincible());
            }
        };
        timer.schedule(task, 3000);
        // reset back to vulnerable here?
        //player.setPlayerState(new Vulnerable());
    }

}
