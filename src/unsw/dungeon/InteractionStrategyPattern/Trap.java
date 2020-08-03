package unsw.dungeon.InteractionStrategyPattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.TrapStatePattern.TrapSetState;
import unsw.dungeon.TrapStatePattern.TrapState;
import unsw.dungeon.TrapStatePattern.TrapUnsetState;
import unsw.dungeon.LayerEnum;

public class Trap extends Entity implements Interaction {

    private TrapState state;
    private Dungeon dungeon;

    public Trap(Dungeon d, int x, int y) {
        super(x,y);
        this.viewOrder().set(LayerEnum.BOTTOM.getZIndex());
        this.dungeon = d;
        this.state = new TrapUnsetState();
    }
    @Override
    public void performInteraction(Entity entity) {
        state.performInteraction(entity, this);
    }

    public void isUsedOnEnemy() {
        this.dungeon.removeEntity(this);
    }

    public void changeState() {
        if (state instanceof TrapUnsetState) {
            this.state = new TrapSetState();
        } else {
            this.state = new TrapUnsetState();
        }
    }

    public TrapState getState() {
        return this.state;
    }
}
