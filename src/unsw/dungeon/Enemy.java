package unsw.dungeon;

// import unsw.dungeon.EnemyStatePattern.EnemyState;
// import unsw.dungeon.EnemyStatePattern.ScaredState;
// import unsw.dungeon.EnemyStatePattern.NormalState;

public class Enemy extends Entity implements Observer {

    // EnemyState scaredState;
    // EnemyState normalState;

    public Enemy(int x, int y) {
        super(x, y);
        // scaredState = new ScaredState(this);
        // normalState = new NormalState(this);

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
        // Check if player has invincibility potion
        boolean isPlayerInvincible = false;
        for (Entity entity : player.getListOfItemsInInventory()) {
            if (entity instanceof InvincibilityPotion) {
                isPlayerInvincible = true;
            }
        }

        // Check player coordinates
        int playerX = player.getX();
        int playerY = player.getY();

        if (isPlayerInvincible) {
            this.moveAwayPlayer(playerX, playerY);
        } else {
            this.moveTowardPlayer(playerX, playerY);
        }


    }
}