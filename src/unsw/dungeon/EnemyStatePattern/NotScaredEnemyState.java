package unsw.dungeon.EnemyStatePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Portal;
import unsw.dungeon.ObstructionStrategyPattern.Obstruction;
import unsw.dungeon.Player;

import java.util.List;

import static java.lang.StrictMath.abs;

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
            System.out.println("here");
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

        if ( abs(diffX) > abs(diffY) ) {
            if (diffX < 0) {
                enemyX--;
            } else {
                enemyX++;
            }
        } else {
            if (diffY < 0) {
                enemyY--;
            } else {
                enemyY++;
            }
        }

        if (dungeon.isThereObstructionAtXY(player, enemyX, enemyY)) {
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