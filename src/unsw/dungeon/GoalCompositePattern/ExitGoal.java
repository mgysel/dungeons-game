package unsw.dungeon.GoalCompositePattern;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity;
import unsw.dungeon.InteractionStrategyPattern.Enemy;
import unsw.dungeon.InteractionStrategyPattern.Exit;
import unsw.dungeon.Player;

public class ExitGoal implements GoalStrategy {

    @Override
    public boolean isComplete(Dungeon dungeon) {
        if (isPlayerAtExit(dungeon)) {
            System.out.println("made it");
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isPlayerAtExit(Dungeon dungeon) {
        //System.out.println("checking");
        Player p = dungeon.getPlayer();
        int playerX = p.getX();
        int playerY = p.getY();
        int exitX = -1;
        int exitY = -1;

        for (Entity entity : dungeon.getEntities()) {
            if (entity instanceof Exit) {
                exitX = entity.getX();
                exitY = entity.getY();
            }
        }
        //System.out.println("px:"+playerX+" py:"+playerY + " ex:" +exitX+" ey:"+exitY);
        if (playerX == exitX && playerY == exitY) {
            return true;
        } else {
            return false;
        }
    }
}
