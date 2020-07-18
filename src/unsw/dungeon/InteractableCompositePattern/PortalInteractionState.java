package unsw.dungeon.InteractableCompositePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Portal;

public class PortalInteractionState implements InteractionState {

    private Portal portal;

    public PortalInteractionState(Portal portal) {
        this.portal = portal;
    }

    @Override
    public void interactOnDungeon(Dungeon dungeon) {
        //TODO: set new coordinate for player
        //dungeon.setPlayerPosition(newPositon);
    }


}
