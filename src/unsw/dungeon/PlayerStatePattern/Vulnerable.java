package unsw.dungeon.PlayerStatePattern;
import unsw.dungeon.Enemy;
import unsw.dungeon.Player;

public class Vulnerable implements PlayerState {

    @Override
    public void changeState(Player player) {
        player.setPlayerState(this);
    }

    @Override
    public void killEnemy(Player player, Enemy enemy) {
        player.swingSword(enemy);
    }

}
