package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
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
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/boulders.json")));
        //json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
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
        JSONArray goals = json.getJSONArray("goals");

        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }

        for (int i = 0; i < goals.length(); i++) {
            addGoalToGame(goals.get(i));
        }
        return dungeon;
    }

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
            onLoad(wall);
            entity = wall;
            break;
        case "treasure": 
            Treasure treasure = new Treasure(dungeon,x,y);
            onLoad(treasure);
            entity = treasure;
            break;
        case "boulder":
            Boulder boulder = new Boulder(dungeon, x, y);
            onLoad(boulder);
            entity = boulder;
            break;
        case "portal":
            id = json.getInt("id");
            Portal portal = new Portal(x, y, id);
            onLoad(portal);
            entity = portal;
            break;
        case "door":
            id = json.getInt("id");
            Door door = new Door(x,y,id);
            onLoad(door);
            entity = door;
            break;
        case "key":
            id = json.getInt("id");
            Key key = new Key(x,y,id);
            onLoad(key);
            entity = key;
            break;
        }
        dungeon.addEntity(entity);
    }

    public abstract void onLoad(Entity player);

    public abstract void onLoad(Wall wall);

    public abstract void onLoad(Treasure treasure);

    public abstract void onLoad(Boulder boulder);

    public abstract void onLoad(Portal portal);

    // TODO Create additional abstract methods for the other entities
    private void addGoalToGame(Object goal) {
        //switch (type) {
        //        case "player":
        //            Player player = new Player(dungeon, x, y);
        //            dungeon.setPlayer(player);
    }

}
