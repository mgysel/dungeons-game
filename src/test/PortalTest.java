package test;
import unsw.dungeon.Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unsw.dungeon.InteractionStrategyPattern.Portal;
import unsw.dungeon.Player;

public class PortalTest {

    @Test
    public void portalMovesPlayerToCorrespondingPortal() {
        Dungeon d = new Dungeon(5, 5);
        Player player = new Player(d, 2, 1);
        Portal portalA = new Portal(d,2,2,0);
        Portal portalB = new Portal(d,4,4,0);
        d.addEntity(portalA);
        d.addEntity(portalB);
        assertEquals(player.getY(),1);
        player.moveDown();
        assertEquals(player.getY(),4);
    }

    @Test
    public void portalDoesNotMovePlayerToIncorrectPortal(){
        Dungeon d = new Dungeon(3, 3);
        Player player = new Player(d, 2, 1);
        Portal portalA = new Portal(d,2,2,0);
        Portal portalB = new Portal(d,4,4,1);
    }
}