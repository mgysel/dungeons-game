package test;
import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unsw.dungeon.InteractionStrategyPattern.Boulder;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Portal;
import unsw.dungeon.Player;

public class PortalTest {

    @Test
    public void portalIsLoadedCorrectly() {
        Dungeon d = new Dungeon(5, 5);
        Portal portal = new Portal(d,2,2,0);
        assertEquals(2, portal.getY());
        assertEquals(2, portal.getX());
    }

    @Test
    public void portalMovesPlayerToCorrespondingPortal() {
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 1);
        Portal portalA = new Portal(d,1,1,0);
        Portal portalB = new Portal(d,4,4,0);
        d.setPlayer(player);
        d.addEntity(portalA);
        d.addEntity(portalB);
        assertEquals(player.getY(),1);
        assertEquals(player.getX(),2);
        player.moveLeft();
        assert(player.getY() >= 3);
    }

    @Test
    public void portalDoesNotMovePlayerToIncorrectPortal(){
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 1);
        Portal portalA = new Portal(d,2,2,0);
        Portal portalB = new Portal(d,4,4,1);
        d.addEntity(portalA);
        d.addEntity(portalB);
        d.setPlayer(player);
        assertEquals(1, player.getY());
        player.moveDown();
        assertEquals(player.getY(),2);
        player.moveDown();
        assertEquals(player.getY(),3);
    }

    @Test
    public void portalIsBidirectional() {
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 1);
        Portal portalA = new Portal(d,1,1,0);
        Portal portalB = new Portal(d,4,4,0);
        d.addEntity(portalA);
        d.addEntity(portalB);
        assertEquals(player.getY(),1);
        assertEquals(player.getX(),2);
        player.moveLeft();
        assert(player.getY() >= 3);
        portalB.performInteraction(player);
        assert(player.getY() <= 2);
    }


    @Test
    public void portalMovesEnemy() {
        Dungeon d = new Dungeon(5, 5);
        Portal portalA = new Portal(d, 2, 2, 0);
        Portal portalB = new Portal(d, 4, 4, 0);
        Player player = new Player(d, 3, 2);
        d.setPlayer(player);
        d.addEntity(portalA);
        d.addEntity(portalB);
        Enemy enemy = new Enemy(d, 0, 2);
        d.addEntity(enemy);;
        assert(enemy.getX() <= 1);
        portalA.performInteraction(enemy);
        assert(enemy.getX() >= 3);
    }

    @Test
    public void portalMovesBoulder() {
        Dungeon d = new Dungeon(5, 5);
        Portal portalA = new Portal(d, 2, 2, 0);
        Portal portalB = new Portal(d, 4, 4, 0);
        Player player = new Player(d, 3, 2);
        d.setPlayer(player);
        d.addEntity(portalA);
        d.addEntity(portalB);
        Boulder b = new Boulder(d, 0, 2);
        d.addEntity(b);;
        assert(b.getX() <= 1);
        portalA.performInteraction(b);
        assert(b.getX() >= 3);
    }

}