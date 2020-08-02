package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.EnemyStatePattern.NotScaredEnemyState;
import unsw.dungeon.EnemyStatePattern.ScaredEnemyState;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.InvincibilityPotion;
import unsw.dungeon.InteractionStrategyPattern.Sword;
import unsw.dungeon.PlayerStatePattern.Invincible;
import unsw.dungeon.PlayerStatePattern.PlayerState;

/**
 * Test for Enemy entity
 */
public class EnemyTest {
    @Test
    public void location() {
        Dungeon dungeon = new Dungeon(10, 10);
        Enemy enemy = new Enemy(dungeon, 1, 1);
        assertEquals(enemy.getX(), 1);
        assertEquals(enemy.getY(), 1);
    }

    @Test
    public void NotScaredWhenPlayerVulnerable() {
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 0);
        dungeon.setPlayer(player);
        Enemy enemy = new Enemy(dungeon, 1, 1);
        dungeon.addEntity(enemy);
        assert (enemy.getState() instanceof NotScaredEnemyState);
    }

    @Test
    public void ScaredWhenPlayerInvincible() {
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 0);
        dungeon.setPlayer(player);
        Enemy enemy = new Enemy(dungeon, 1, 1);
        dungeon.addEntity(enemy);
        PlayerState invincibleState = new Invincible();
        player.setPlayerState(invincibleState);
        assert(enemy.getState() instanceof ScaredEnemyState);
    }

    @Test
    public void enemyMoveTowardPlayerWhenNotScared() throws InterruptedException {
        // Up/Left
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 0);
        dungeon.setPlayer(player);
        Enemy enemy = new Enemy(dungeon, 5, 5);
        dungeon.addEntity(enemy);
        Thread.sleep(4500);
        assert(enemy.getX() < 5);
        assert(enemy.getY() < 5);

        // Down/Right
        dungeon = new Dungeon(10, 10);
        player = new Player(dungeon, 5, 5);
        dungeon.setPlayer(player);
        enemy = new Enemy(dungeon, 0, 0);
        dungeon.addEntity(enemy);
        Thread.sleep(4500);
        assert(enemy.getX() > 0);
        assert(enemy.getY() > 0);
    }

    @Test
    public void enemyMoveAwayFromPlayerWhenScared() throws InterruptedException {
        // Right/Down
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 1, 1);
        InvincibilityPotion invincibilityPotion = new InvincibilityPotion(2, 1);
        dungeon.setPlayer(player);
        Enemy enemy = new Enemy(dungeon, 5, 5);
        dungeon.addEntity(invincibilityPotion);
        dungeon.addEntity(enemy);
        player.moveRight();
        player.moveRight();
        Thread.sleep(3500);
        assertEquals(5, enemy.getX());

        // // Left/Up
        // dungeon = new Dungeon(10, 10);
        // player = new Player(dungeon, 8, 9);
        // invincibilityPotion = new InvincibilityPotion(9, 9);
        // dungeon.setPlayer(player);
        // enemy = new Enemy(dungeon, 5, 5);
        // dungeon.addEntity(invincibilityPotion);
        // dungeon.addEntity(enemy);
        // player.moveRight();
        // player.moveRight();
        // Thread.sleep(3500);
        // assert(enemy.getY() < 5 || enemy.getX() < 5);
        
    }

    @Test
    public void EnemyKillsVulnerablePlayerWithoutSword() {
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 1);
        dungeon.setPlayer(player);
        Enemy enemy = new Enemy(dungeon, 1, 1);
        dungeon.addEntity(enemy);
        player.moveRight();
        assert(dungeon.getPlayer() == null);
    }

    @Test
    public void InvinciblePlayerKillsEnemy() {
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 1, 2);
        InvincibilityPotion invinciblityPotion = new InvincibilityPotion(2, 2);
        Enemy enemy = new Enemy(dungeon, 3, 2);
        dungeon.setPlayer(player);
        dungeon.addEntity(enemy);
        dungeon.addEntity(invinciblityPotion);
        player.moveRight();
        player.moveRight();
        assert(!dungeon.getEntities().contains(enemy));
    }

    @Test
    public void PlayerWithSwordKillsEnemy() {
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 1);
        Sword sword = new Sword(1, 1);
        dungeon.setPlayer(player);
        Enemy enemy = new Enemy(dungeon, 3, 1);
        dungeon.addEntity(enemy);
        dungeon.addEntity(sword);
        player.moveRight();
        player.moveRight();
        enemy.performInteraction(player);
        assert(!dungeon.getEntities().contains(enemy));
    }

}