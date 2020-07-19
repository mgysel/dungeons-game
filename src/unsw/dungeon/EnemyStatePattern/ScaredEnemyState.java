package unsw.dungeon.EnemyStatePattern;

import unsw.dungeon.Enemy;
import unsw.dungeon.Player;

public class ScaredEnemyState implements EnemyState {

    Enemy enemy;

    public ScaredEnemyState(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void performInteraction(Player player) {
        // player is invincible,
        // kills enemy without using sword
        player.removeEnemy(enemy);
    }

    @Override
    public void moveEnemy(Player player) {

    }


}