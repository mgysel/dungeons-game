package unsw.dungeon.EnemyStatePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Boulder;
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
        enemy.doesExist().set(false);
    }

    @Override
    public void moveEnemy(Player player, Dungeon dungeon) {
        // move enemy away from player
        int enemyX = enemy.getX();
        int enemyY = enemy.getY();
        int diffX = getPlayerX(player) - enemyX;
        int diffY = getPlayerY(player) - enemyY;

        System.out.println("here");

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

        if (dungeon.isThereObstructionAtXY(enemyX, enemyY) || isBoulder(enemyX, enemyY, dungeon)) {
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

    private boolean isBoulder(int x, int y, Dungeon dungeon) {
        for (Entity entity : dungeon.getEntities(x,y)) {
            if (entity instanceof Boulder) {
                return true;
            } else {
                continue;
            }
        } return false;
    }
}