package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Entity;
import unsw.dungeon.Player;
import unsw.dungeon.PlayerStatePattern.Invincible;
import unsw.dungeon.PlayerStatePattern.Vulnerable;
import unsw.dungeon.LayerEnum;

import java.util.Timer;
import java.util.TimerTask;

public class InvincibilityPotion extends Entity implements Interaction {

    public InvincibilityPotion(int x, int y) {
        super(x, y);
        this.viewOrder().set(LayerEnum.INVENTORY.getZIndex());
    }

    @Override
    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addItemToInventory(this);
            player.setPlayerState(new Invincible());
            InvincibilityPotion thisPotion = this;
            new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        player.setPlayerState(new Vulnerable());
                        player.removeItemFromInventory(thisPotion);
                    }
                },
                5000
            );
        }
    }
}
