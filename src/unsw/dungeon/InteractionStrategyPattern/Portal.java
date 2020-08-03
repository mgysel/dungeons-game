package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Player;
import unsw.dungeon.LayerEnum;
// import unsw.dungeon.Dungeon;
// import unsw.dungeon.ObserverPattern.Subject;

public class Portal extends Entity implements Interaction {

    private int portalPairID;
    private Dungeon dungeon;

    public Portal(Dungeon dungeon, int x, int y, int portalPairID) {
        super(x, y);
        this.viewOrder().set(LayerEnum.BOTTOM.getZIndex());
        this.portalPairID = portalPairID;
        this.dungeon = dungeon;
    }

    public void performInteraction(Entity entity) {
        if (entity instanceof Player || entity instanceof Boulder || entity instanceof Enemy ) {
            entity.x().set(getXCoordToMoveTo(entity));
            entity.y().set(getYCoordToMoveTo(entity));
        }
    }


    private int getXCoordToMoveTo(Entity entity) {
        int entityX = entity.getX();
        int fromPortalX = getX();
        Portal toPortal = getCorrespondingPortal();
        if (toPortal != null) {
            int toPortalX = toPortal.getX();
            return (entityX - fromPortalX + toPortalX);
        } else {
            return entityX;
        }

    }

    private int getYCoordToMoveTo(Entity entity) {
        int entityY = entity.getY();
        int fromPortalY = getY();
        Portal toPortal = getCorrespondingPortal();
        if (toPortal != null) {
            int toPortalY = toPortal.getY();
            return (entityY - fromPortalY + toPortalY);
        } else {
            return entityY;
        }
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

