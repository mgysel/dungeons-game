package unsw.dungeon.EnemyStatePattern;

import unsw.dungeon.Enemy;
import unsw.dungeon.Player;

public class NotScaredEnemyState implements EnemyState {

    Enemy enemy;

    public NotScaredEnemyState(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void performInteraction(Player player) {
        // if player has sword
        if (player.hasSword()) {
            player.swingSword(enemy);
        } else {
            // if player doesn't have sword, enemy kills player
            player.dies();
        }

    }

    @Override
    public void moveEnemy(Player player) {

    }

}