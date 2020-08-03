package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.ObstructionStrategyPattern.Wall;
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
            setCoordsToMoveTo(entity);
        }
    }


    private void setCoordsToMoveTo(Entity entity) {
        int entityX = entity.getX();
        int entityY = entity.getY();
        Portal toPortal = getCorrespondingPortal();
        if (toPortal != null) {
            int PX = toPortal.getX();
            int PY = toPortal.getY();
            for (int i = PX-1; i<PX+2; i++) {
                for (int j = PY-1; j<PY+2; j++) {
                    if (canTeleportHere(i,j)) {
                        System.out.println("i"+i+" j"+j);
                        setNewCoords(entity,i,j);
                        return;
                    } else {
                        continue;
                    }
                }
            }
        }
        setNewCoords(entity, entityX, entityY);
        return;
    }

    private void setNewCoords(Entity entity, int x, int y) {
        entity.x().set(x);
        entity.y().set(y);
    }

    private boolean canTeleportHere(int x, int y) {
        for (Entity entity : dungeon.getEntities(x,y)) {
            if (entity instanceof Wall || entity instanceof Boulder || entity instanceof Trap || entity instanceof Lava) {
                return false;
            }
        } return true;
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

