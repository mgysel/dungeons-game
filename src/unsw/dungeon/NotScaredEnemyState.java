package unsw.dungeon;

public class NotScaredEnemyState implements EnemyState {

    Enemy enemy;

    public NotScaredEnemyState(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void performInteraction(Dungeon dungeon, Player player) {
        // TODO Auto-generated method stub
        dungeon.removeEntity(player);
    }
    
}