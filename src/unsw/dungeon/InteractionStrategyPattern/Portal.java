package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Player;
// import unsw.dungeon.Dungeon;
// import unsw.dungeon.ObserverPattern.Subject;

public class Portal extends Entity implements Interaction {

    private int portalPairID;
    private Dungeon dungeon;

    public Portal(Dungeon dungeon, int x, int y, int portalPairID) {
        super(x, y);
        this.portalPairID = portalPairID;
        this.dungeon = dungeon;
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
        for (Entity entity : this.dungeon.getEntities()) {
            if (entity instanceof Portal && entity != this) {
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

