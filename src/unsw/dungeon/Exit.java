package unsw.dungeon;
import unsw.dungeon.ExitStatePattern.ClosedExit;
import unsw.dungeon.ExitStatePattern.ExitState;
import unsw.dungeon.ExitStatePattern.OpenExit;

/**
 * Exit that players move through when goals completed to finish dungeon
 * @author Ben Charlton
 */
public class Exit extends Entity {

    // i think it would be a good idea to have a state pattern here
    // so that we dont need to couple it to the dungeon
    // in order to find out if the goals have been complete yet or not

    private ExitState state;

    public Exit(int x, int y) {
        super(x,y);
        this.state = new ClosedExit();
    }

     public void openExit() {
        this.state = new OpenExit();
     }

     public ExitState getState() {
         return state;
     }

}
