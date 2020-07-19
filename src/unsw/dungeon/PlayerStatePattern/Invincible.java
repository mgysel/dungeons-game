package unsw.dungeon.PlayerStatePattern;

import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.Player;

public class Invincible implements PlayerState {

    @Override
    public void changeState(Player player) {
        player.setPlayerState(this);
    }

    @Override
    public void killEnemy(Player player, Enemy enemy) {
        player.removeEnemy(enemy);
    }

}
