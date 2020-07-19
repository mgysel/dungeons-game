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
        // player.addItemToInventory(this);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                
                player.setPlayerState(new Invincible());
            }
        };
        timer.schedule(task, 3000);
        // reset back to vulnerable here?
        //player.setPlayerState(new Vulnerable());

        // Another potential option could be for player to change state if invincibility potion in inventory
        // Maybe player.addItemToInventory() function inside player can change the player state
        // player.removeInventory(this);
        
    }

}
