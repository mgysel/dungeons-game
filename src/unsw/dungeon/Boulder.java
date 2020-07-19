package unsw.dungeon;

import java.util.List;

public class Boulder extends Entity implements Obstruction, Interaction {

    private Dungeon dungeon;

    public Boulder(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
    }

    public void move(int x, int y) {
        x().set(x);
        y().set(y);
    }

    @Override
    public boolean isObstruction(Player player) {
        int playerX = player.getX();
        int playerY = player.getY();
        int thisX = getX();
        int thisY = getY();
        int nextX = (thisX - playerX) + thisX;
        int nextY = (thisY - playerY) + thisY;

        System.out.println("PLAYER X: "+thisX);
        System.out.println("PLAYER Y: "+thisY);
        System.out.println("THIS X: "+thisX);
        System.out.println("THIS Y: "+thisY);
        System.out.println("NEXT X: "+nextX);
        System.out.println("NEXT Y: "+nextY);

        List<Entity> xyEntities = dungeon.getEntities(nextX, nextY);
        for (Entity entity : xyEntities) {
            if (entity != null) {
                if (entity instanceof Boulder || entity instanceof Wall) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void performInteraction(Player player) {
        int playerX = player.getX();
        int playerY = player.getY();
        int thisX = getX();
        int thisY = getY();
        int nextX = (thisX - playerX) + thisX;
        int nextY = (thisY - playerY) + thisY;
        // List<Entity> xyEntities = dungeon.getEntities(nextX, nextY);
        // for (Entity entity : xyEntities) {
        //     if (entity != null) {
        //         if (entity instanceof Boulder || entity instanceof Wall) {
        //             return;
        //         }
        //     }
            
        // }
        System.out.println("PLAYER X: "+thisX);
        System.out.println("PLAYER Y: "+thisY);
        System.out.println("THIS X: "+thisX);
        System.out.println("THIS Y: "+thisY);
        System.out.println("NEXT X: "+nextX);
        System.out.println("NEXT Y: "+nextY);

        move(nextX, nextY);
    }

    

    // public void move() {
    //     if (getY() > 0)
    //         y().set(getY() - 1);
    // }

    // private List<Entity> returnEntities(int x, int y) {
    //     List<Entity> xyEntities = dungeon.getEntities(x, y);
    //     System.out.println("XY ENTITIES LENGTH: " + xyEntities.size());
    //     for (Entity entity : xyEntities) {
    //         if (entity != null) {
    //             System.out.println("ENTITIES BEFORE: " + entity);
    //             if (entity.getX() == x && entity.getY() == y) {
    //                 System.out.println("ENTITIES AFTER: " + entity);
    //                 xyEntities.add(entity);
    //             }
    //         }
    //     }
    //     return xyEntities;
    // }

}