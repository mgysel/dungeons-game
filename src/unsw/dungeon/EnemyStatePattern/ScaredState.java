package unsw.dungeon.EnemyStatePattern;
import unsw.dungeon.*;

public class ScaredState implements EnemyState {

    Enemy enemy;

    public ScaredState(Enemy enemy) {
        this.enemy = enemy;
    }

    public void scare() {
        // Do nothing
    }

    public void unscare() {
        enemy.moveTowardPlayer();
    }
}
