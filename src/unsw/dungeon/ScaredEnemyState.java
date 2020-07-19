package unsw.dungeon;

public class ScaredEnemyState implements EnemyState {
    Enemy enemy;

    public ScaredEnemyState(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void performInteraction(Dungeon dungeon, Player player) {
        // TODO Auto-generated method stub
        // Check player coordinates
        // boolean isPlayerInvincible = player.getIsPlayerInvincible();
        // boolean playerHasSword = player.geyPlayerHasSword();

        // // Should encapsulate this in different InteractWithPlayer() functions for each state
        // if (isPlayerInvincible ) {
        //     dungeon.removeEntity(this);
        // } else if (!isPlayerInvincible && playerX == getX() && playerY == getY()) {
        //     dungeon.removeEntity(player);
        // } else if (isPlayerInvincible) {
        //     this.moveAwayPlayer(playerX, playerY);
        // } else {
        //     this.moveTowardPlayer(playerX, playerY);
        // }
        dungeon.removeEntity(enemy);
    }

    
}