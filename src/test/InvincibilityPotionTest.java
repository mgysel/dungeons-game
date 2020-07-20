package test;
import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unsw.dungeon.EnemyStatePattern.NotScaredEnemyState;
import unsw.dungeon.EnemyStatePattern.ScaredEnemyState;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.*;
import unsw.dungeon.Player;
import unsw.dungeon.PlayerStatePattern.Invincible;
import unsw.dungeon.PlayerStatePattern.Vulnerable;

import java.util.concurrent.TimeUnit;

public class InvincibilityPotionTest {

    @Test
    public void potionCanBePickedUpByPlayer() {
        Dungeon d = new Dungeon(5, 5);
        InvincibilityPotion pot = new InvincibilityPotion(2, 2);
        Player p = new Player(d,1,2);
        d.addEntity(pot);
        d.setPlayer(p);
        assertEquals(0,p.getListOfItemsInInventory().size());
        p.moveRight();
        assertEquals(1,p.getListOfItemsInInventory().size());
    }

    @Test
    public void potionEffectWearsOff() throws InterruptedException {
        Dungeon d = new Dungeon(5, 5);
        InvincibilityPotion pot = new InvincibilityPotion(2, 2);
        Player p = new Player(d,1,2);
        d.setPlayer(p);
        assert(p.getState() instanceof Vulnerable);
        d.addEntity(pot);
        p.moveRight();
        assert(p.getState() instanceof Invincible);
        TimeUnit.SECONDS.sleep(6);
        assert(p.getState() instanceof Vulnerable);
    }

    @Test
    public void playerAndEnemyStateSetWhenActive() {
        Dungeon d = new Dungeon(5, 5);
        InvincibilityPotion pot = new InvincibilityPotion(2, 2);
        Player p = new Player(d,1,2);
        Enemy e = new Enemy(d,5,5);
        d.setPlayer(p);
        d.addEntity(pot);
        d.addEntity(e);
        assert(p.getState() instanceof Vulnerable);
        assert(e.getState() instanceof NotScaredEnemyState);
        p.moveRight();
        p.moveRight();
        assert(p.getState() instanceof Invincible);
        assert(e.getState() instanceof ScaredEnemyState);
    }

    @Test
    public void enemyDiesUponImpact() {
        Dungeon d = new Dungeon(5, 5);
        InvincibilityPotion pot = new InvincibilityPotion(2, 2);
        Player p = new Player(d,1,2);
        Enemy e = new Enemy(d,5,5);
        d.setPlayer(p);
        d.addEntity(pot);
        d.addEntity(e);
        p.moveRight();
        p.moveRight();
        assertEquals(1,d.getEntities().size());
        e.performInteraction(p);
        assertEquals(0,d.getEntities().size());
    }

    /*
    @Test
    public void enemyRunsWhilePlayerInvincible() {
    }*/

}