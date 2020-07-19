package unsw.dungeon.EnemyStatePattern;
import unsw.dungeon.*;

public class NormalState implements EnemyState {
    
    Enemy enemy;

    public NormalState(Enemy enemy) {
        this.enemy = enemy;
    }

    public void scare() {
        enemy.moveTowardPlayer();
    }

    public void unscare() {
        // Do nothing
        enemy.moveAwayPlayer();
    }
}
