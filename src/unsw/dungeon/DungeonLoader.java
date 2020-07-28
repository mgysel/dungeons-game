package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import unsw.dungeon.GoalCompositePattern.CompositeGoal;
import unsw.dungeon.GoalCompositePattern.Goal;
import unsw.dungeon.GoalCompositePattern.LeafGoal;
import unsw.dungeon.InteractionStrategyPattern.*;
import unsw.dungeon.ObstructionStrategyPattern.Wall;

/**
 * Loads a dungeon from a .json file.
 *
 * By extending this class, a subclass can hook into entity creation. This is
 * useful for creating UI elements with corresponding entities.
 *
 * @author Robert Clifton-Everest
 *
 */
public abstract class DungeonLoader {

    private JSONObject json;

    public DungeonLoader(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        int width = json.getInt("width");
        int height = json.getInt("height");

        Dungeon dungeon = new Dungeon(width, height);

        JSONArray jsonEntities = json.getJSONArray("entities");
        //JSONObject jsonGoal = json.getJSONObject("goal-condition");
        //dungeon.setGoal(loadGoals(jsonGoal));

        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }

        return dungeon;
    }



    // private Goal loadGoals(JSONObject jsonGoal){
    //     String goal = jsonGoal.getString("goal");
    //     if (goal.equals("AND") || goal.equals("OR")) {
    //         JSONArray jsonGoals = jsonGoal.getJSONArray("subgoals");
    //         CompositeGoal curGoal = new CompositeGoal(goal);
    //         for(int i = 0; i < jsonGoals.length(); i++){
    //             curGoal.addGoal(loadGoals(jsonGoals.getJSONObject(i)));
    //         }
    //         return curGoal;
    //     } else {
    //         return new LeafGoal(goal);
    //     }
    // }



    private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");
        int id = 0;

        Entity entity = null;
        switch (type) {
        case "player":
            Player player = new Player(dungeon, x, y);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(x, y);
            dungeon.addEntity(wall);
            onLoad(wall);
            entity = wall;
            break;
        case "exit":
            Exit exit = new Exit(dungeon, x, y);
            dungeon.addEntity(exit);
            onLoad(exit);
            entity = exit;
            break;
        case "treasure":
            Treasure treasure = new Treasure(dungeon,x,y);
            dungeon.addEntity(treasure);
            onLoad(treasure);
            entity = treasure;
            break;
        case "door":
            id = json.getInt("id");
            Door door = new Door(x,y,id);
            dungeon.addEntity(door);
            onLoad(door);
            entity = door;
            break;
        case "key":
            id = json.getInt("id");
            Key key = new Key(x,y,id);
            dungeon.addEntity(key);
            onLoad(key);
            entity = key;
            break;
        case "boulder":
            Boulder boulder = new Boulder(dungeon, x, y);
            dungeon.addEntity(boulder);
            onLoad(boulder);
            entity = boulder;
            break;
        case "floor switch":
            FloorSwitch floorSwitch = new FloorSwitch(dungeon, x, y);
            dungeon.addEntity(floorSwitch);
            onLoad(floorSwitch);
            entity = floorSwitch;
            break;
        case "portal":
            id = json.getInt("id");
            Portal portal = new Portal(dungeon, x, y, id);
            dungeon.addEntity(portal);
            onLoad(portal);
            entity = portal;
            break;
        case "enemy":
            Enemy enemy = new Enemy(dungeon, x, y);
            dungeon.addEntity(enemy);
            onLoad(enemy);
            entity = enemy;
            break;
        case "sword":
            Sword sword = new Sword(x, y);
            dungeon.addEntity(sword);
            onLoad(sword);
            entity = sword;
            break;
        case "invincibility potion":
            InvincibilityPotion invincibilityPotion = new InvincibilityPotion(x, y);
            dungeon.addEntity(invincibilityPotion);
            onLoad(invincibilityPotion);
            entity = invincibilityPotion;
            break;
        }
        dungeon.addEntity(entity);
    }

    public abstract void onLoad(Entity player);
    public abstract void onLoad(Wall wall);
    public abstract void onLoad(Exit exit);
    public abstract void onLoad(Treasure treasure);
    public abstract void onLoad(Door door);
    public abstract void onLoad(Key key);
    public abstract void onLoad(Boulder boulder);
    public abstract void onLoad(FloorSwitch floorSwitch);
    public abstract void onLoad(Portal portal);
    public abstract void onLoad(Enemy enemy);
    public abstract void onLoad(Sword sword);
    public abstract void onLoad(InvincibilityPotion invincibilityPotion);

}
