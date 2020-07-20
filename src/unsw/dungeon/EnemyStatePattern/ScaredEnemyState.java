package unsw.dungeon.EnemyStatePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.Player;

import static java.lang.StrictMath.abs;

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
    public void moveEnemy(Player player, Dungeon dungeon) {
        // move enemy away from player
        int enemyX = enemy.getX();
        int enemyY = enemy.getY();
        int diffX = getPlayerX(player) - enemyX;
        int diffY = getPlayerY(player) - enemyY;

        if ( abs(diffX) > abs(diffY) ) {
            if (diffX < 0) {
                enemyX++;
            } else {
                enemyX--;
            }
        } else {
            if (diffY < 0) {
                enemyY++;
            } else {
                enemyY--;
            }
        }

        if (dungeon.isThereObstructionAtXY(enemyX, enemyY)) {
            // do nothing because obstruction in the way)
        } else {
            enemy.x().set(enemyX);
            enemy.y().set(enemyY);
        }
    }

    private int getPlayerX(Player player) {
        return player.getX();
    }

    private int getPlayerY(Player player) {
        return player.getY();
    }

}