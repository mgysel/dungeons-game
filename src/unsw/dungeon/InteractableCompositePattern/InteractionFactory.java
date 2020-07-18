package unsw.dungeon.InteractableCompositePattern;

import unsw.dungeon.Door;
import unsw.dungeon.Entity;
import unsw.dungeon.Portal;

public class InteractionFactory {

    public static Interactable getInteractionForEntity(Entity entity) {
        if(entity instanceof Portal) {
            return new PortalInteraction((Portal) entity);
        } else if (entity instanceof Key) {
            return new KeyInteraction((Key) entity);
        } else if (entity instanceof Boulder) {
            return new BoulderInteraction((Boulder) entity);
        } else if (entity instanceof Enemy) {
            return new EnemyInteraction((Enemy) entity);
        } else if (entity instanceof Potion) {
            return new PotionInteraction((Potion) entity);
        } else if (entity instanceof Door) {
            return new DoorInteraction((Door) entity);
        }
        return null;
    }
}
