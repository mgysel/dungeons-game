package unsw.dungeon;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.sound.sampled.Port;
// import unsw.dungeon.Dungeon;
// import unsw.dungeon.Subject;

public class Portal extends Entity {

    private int portalPairID;
    private Dungeon dungeon;

    public Portal(int x, int y, int portalPairID) {
        super(x, y);
        this.portalPairID = portalPairID;
    }

    public void performInteraction(Player player) {
        player.x().set(getXCoordToMoveTo(player));
        player.y().set(getYCoordToMoveTo(player));
    }

    private int getXCoordToMoveTo(Player player) {
        int playerX = player.getX();
        int fromPortalX = getX();
        Portal toPortal = getCorrespondingPortal();
        int toPortalX = toPortal.getX();

        return (playerX - fromPortalX + toPortalX);
    }

    private int getYCoordToMoveTo(Player player) {
        int playerY = player.getY();
        int fromPortalY = getY();
        Portal toPortal = getCorrespondingPortal();
        int toPortalY = toPortal.getY();

        return (playerY - fromPortalY + toPortalY);
    }


    private Portal getCorrespondingPortal() {
        for (Entity entity : dungeon.getEntities()) {
            if (entity instanceof Portal) {
                if (((Portal) entity).getPortalPairID() == this.portalPairID){
                    return (Portal) entity;
                }
            }
        } return null;
    }

    private int getPortalPairID() {
        return this.portalPairID;
    }

}

