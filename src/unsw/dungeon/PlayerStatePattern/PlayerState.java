package unsw.dungeon.PlayerStatePattern;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.Player;

public interface PlayerState {
        public void changeState(Player player);
}
