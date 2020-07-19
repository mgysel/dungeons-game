package unsw.dungeon;

// import unsw.dungeon.EnemyStatePattern.EnemyState;
// import unsw.dungeon.EnemyStatePattern.ScaredState;
// import unsw.dungeon.EnemyStatePattern.NormalState;

import unsw.dungeon.EnemyStatePattern.EnemyState;
import unsw.dungeon.EnemyStatePattern.NotScaredEnemyState;
import unsw.dungeon.EnemyStatePattern.ScaredEnemyState;
import unsw.dungeon.PlayerStatePattern.Invincible;

public class Enemy extends Entity implements Observer, Goal {

    Dungeon dungeon;
    EnemyState scaredState;
    EnemyState notScaredState;
    EnemyState state;

    public Enemy(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        scaredState = new ScaredEnemyState(this);
        notScaredState = new NotScaredEnemyState(this);
        this.state = notScaredState;
        moveEnemy(dungeon.getPlayer());
    }

    public void moveEnemy(Player player) {
        // every second,
        state.moveEnemy(player);
    }

    @Override
    public void update(Player player) {
        // If player is invincible, change state to scared
        if (player.getState() instanceof Invincible) {
            this.state = scaredState;
        } else {
            // If player does not have invincible, change state to not scared
            this.state = notScaredState;
        }
    }

    @Override
    public void performInteraction(Player player) {
        state.performInteraction(player);
    }

    @Override
    public boolean isComplete() {
        // if the enemy is in the map still
        // then it has not been killed so the goal
        // of killing all enemies is not complete
        if (dungeon.getEntities().contains(this)) {
            return false;
        } return true;
    }
    
}