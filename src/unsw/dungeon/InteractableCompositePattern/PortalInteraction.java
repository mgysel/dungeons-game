package unsw.dungeon.InteractableCompositePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Portal;

public class PortalInteraction implements Interactable {

    private Portal portal;

    public PortalInteraction(Portal portal) {
        this.portal = portal;
    }

    @Override
    public void interactOnDungeon(Dungeon dungeon) {
        //TODO: set new coordinate for player
    }


}
