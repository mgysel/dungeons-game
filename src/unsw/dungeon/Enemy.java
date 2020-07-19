package unsw.dungeon;

// import unsw.dungeon.EnemyStatePattern.EnemyState;
// import unsw.dungeon.EnemyStatePattern.ScaredState;
// import unsw.dungeon.EnemyStatePattern.NormalState;

public class Enemy extends Entity implements Observer, Goal {

    Dungeon dungeon;
    EnemyState scaredState;
    EnemyState notScaredState;

    EnemyState state = notScaredState;

    public Enemy(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        scaredState = new ScaredEnemyState(this);
        notScaredState = new NotScaredEnemyState(this);

    }

    public void moveTowardPlayer(int x, int y) {
        // Observe player location, move toward player

    }

    public void moveAwayPlayer(int x, int y) {
        // Observe when player gets Invincibility Potion, move away from player for 30
        // seconds
    }

    @Override
    public void update(Player player) {
        // If player is invincible or has sword, change state to scared

        // If player does not have invincible or sword, change state to not scared


        // // Check if player has invincibility potion
        // boolean isPlayerInvincible = false;
        // for (Entity entity : player.getListOfItemsInInventory()) {
        //     if (entity instanceof InvincibilityPotion) {
        //         isPlayerInvincible = true;
        //     }
        // }

        // // Check player coordinates
        // int playerX = player.getX();
        // int playerY = player.getY();

        // // Should encapsulate this in different InteractWithPlayer() functions for each
        // // state
        // if (isPlayerInvincible && playerX == getX() && playerY == getY()) {
        //     dungeon.removeEntity(this);
        // } else if (!isPlayerInvincible && playerX == getX() && playerY == getY()) {
        //     dungeon.removeEntity(player);
        // } else if (isPlayerInvincible) {
        //     this.moveAwayPlayer(playerX, playerY);
        // } else {
        //     this.moveTowardPlayer(playerX, playerY);
        // }

    }

    @Override
    public void performInteraction(Player player) {
        // TODO Auto-generated method stub
        state.performInteraction(dungeon, player);
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