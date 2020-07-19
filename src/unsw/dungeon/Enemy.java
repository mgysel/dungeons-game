package unsw.dungeon;

import unsw.dungeon.EnemyStatePattern.EnemyState;
import unsw.dungeon.EnemyStatePattern.ScaredState;
import unsw.dungeon.EnemyStatePattern.NormalState;

public class Enemy extends Entity {

    // EnemyState scaredState;
    // EnemyState normalState;

    public Enemy(int x, int y) {
        super(x, y);
        // scaredState = new ScaredState(this);
        // normalState = new NormalState(this);

    }
    
    // NEED OBSERVER PATTERN TO OBSERVE PLAYER
    public void moveTowardPlayer() {
        // Observe player location, move toward player

    }

    public void moveAwayPlayer() {
        // Observe when player gets Invincibility Potion, move away from player for 30 seconds
    }
}