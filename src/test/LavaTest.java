package test;

import org.junit.jupiter.api.Test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Lava;
import unsw.dungeon.Player;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LavaTest {

    @Test
    public void lavaKillsPlayer() {
        Dungeon d = new Dungeon(5, 5);
        Player p = new Player(d,3,3);
        Lava l = new Lava(4,3);
        d.setPlayer(p);
        d.addEntity(l);
        p.moveRight();
        assertNull(d.getPlayer());
    }

    @Test
    public void lavaKillsEnemy() throws InterruptedException {
        Dungeon d = new Dungeon(10, 1);
        Player p = new Player(d,1,1);
        d.setPlayer(p);
        Lava l = new Lava(3,1);
        d.addEntity(l);
        Enemy e = new Enemy(d,5,1);
        d.addEntity(e);
        assertEquals(2, d.getEntities().size());
        e.performInteraction(l);
        assertEquals(1, d.getEntities().size());
    }
}
