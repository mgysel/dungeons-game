package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.Player;
import unsw.dungeon.LayerEnum;

/**
 * Exit that players move through when goals completed to finish dungeon
 * @author Ben Charlton
 */
public class Exit extends Entity implements Interaction {

    private Dungeon dungeon;
    private boolean activated;

    public Exit(Dungeon dungeon, int x, int y) {
        super(x,y);
        this.viewOrder().set(LayerEnum.BOTTOM.getZIndex());
        this.dungeon = dungeon;
        this.activated = false;
    }

    @Override
    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            //System.out.println("hereee");
            // if all other goals complete
            // do nothing?
            // we already check if we finish game
            // ((Player) entity).didIJustFinishGame();
        }
    }




}
