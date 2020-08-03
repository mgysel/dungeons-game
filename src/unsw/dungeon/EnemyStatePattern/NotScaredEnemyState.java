package unsw.dungeon.EnemyStatePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Boulder;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Portal;
import unsw.dungeon.ObstructionStrategyPattern.Obstruction;
import unsw.dungeon.Player;

import java.util.List;

import static java.lang.StrictMath.abs;

public class NotScaredEnemyState implements EnemyState {

    Enemy enemy;
    Boolean direction;

    public NotScaredEnemyState(Enemy enemy) {
        this.enemy = enemy;
        this.direction = true;
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
    public void moveEnemy(Player player, Dungeon dungeon) {
        // move enemy towards player
        int enemyX = enemy.getX();
        int enemyY = enemy.getY();
        int diffX = getPlayerX(player) - enemyX;
        int diffY = getPlayerY(player) - enemyY;

        if ( abs(diffX) > 0 && abs(diffY) > 0) {
            if ( direction ) {
                enemyX = moveX(diffX, enemyX);
            } else {
                enemyY = moveY(diffY, enemyY);
            }
        } else if ( abs(diffX) > 0 ) {
            enemyX = moveX(diffX, enemyX);
        } else if ( abs(diffY) > 0 ) {
            enemyY = moveY(diffY, enemyY);
        }

        if (dungeon.isThereObstructionAtXY(enemyX, enemyY) || isBoulder(enemyX, enemyY, dungeon)) {
            // do nothing because obstruction in the way)
        } else {
            enemy.x().set(enemyX);
            enemy.y().set(enemyY);
        } 
    }

    private int moveX(int diffX, int enemyX) {
        if (diffX < 0) {
            enemyX--;
        } else {
            enemyX++;
        }
        direction = !direction;
        return enemyX;
    }

    private int moveY(int diffY, int enemyY) {
        if (diffY < 0) {
            enemyY--;
        } else {
            enemyY++;
        }
        direction = !direction;
        return enemyY;
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