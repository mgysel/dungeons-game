package unsw.dungeon.EnemyStatePattern;

import unsw.dungeon.Player;

public interface EnemyState {
    public void performInteraction(Player player);
    public void moveEnemy(Player player);
}