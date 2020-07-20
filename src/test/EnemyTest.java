package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Timer;

import org.junit.jupiter.api.Test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.EnemyStatePattern.NotScaredEnemyState;
import unsw.dungeon.EnemyStatePattern.ScaredEnemyState;
import unsw.dungeon.InteractionStrategyPattern.Door;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.InvincibilityPotion;
import unsw.dungeon.InteractionStrategyPattern.Key;
import unsw.dungeon.InteractionStrategyPattern.Sword;
import unsw.dungeon.PlayerStatePattern.Invincible;
import unsw.dungeon.PlayerStatePattern.PlayerState;

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
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 0);
        dungeon.setPlayer(player);
        Enemy enemy = new Enemy(dungeon, 5, 0);
        dungeon.addEntity(enemy);

        Thread.sleep(2000);
        assert(enemy.getX() < 5);
    }

    // Test move away from player when not scared
    @Test
    public void enemyMoveAwayFromPlayerWhenScared() throws InterruptedException {
        Dungeon dungeon = new Dungeon(10, 10);
        Player player = new Player(dungeon, 0, 0);
        InvincibilityPotion invincibilityPotion = new InvincibilityPotion(1, 0);
        dungeon.setPlayer(player);
        Enemy enemy = new Enemy(dungeon, 5, 0);
        dungeon.addEntity(enemy);
        dungeon.addEntity(invincibilityPotion);
        player.moveRight();
        player.moveRight();

        Thread.sleep(3000);
        assert(enemy.getX() > 5);
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
        Player player = new Player(dungeon, 0, 1);
        InvincibilityPotion invinciblityPotion = new InvincibilityPotion(1, 1);
        dungeon.setPlayer(player);
        Enemy enemy = new Enemy(dungeon, 3, 1);
        dungeon.addEntity(enemy);
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
        player.moveRight();
        player.moveRight();
        assert(!dungeon.getEntities().contains(enemy));
    }

    // Test collision with player kills enemy when enemy has sword    

    // Test collision with player kills enemy when scared


}