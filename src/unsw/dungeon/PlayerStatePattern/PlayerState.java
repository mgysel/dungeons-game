package unsw.dungeon.PlayerStatePattern;
import unsw.dungeon.Enemy;
import unsw.dungeon.Player;

public interface PlayerState {
        public void changeState(Player player);
        public void killEnemy(Player player, Enemy enemy);
}
