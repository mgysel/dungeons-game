package unsw.dungeon.ItemCompositePattern;

import unsw.dungeon.Entity;
import unsw.dungeon.Observer;

/**
 * Item abstract class that the item objects (potion,sword,key) will inherit from
 * @author Ben Charlton
 */
public abstract class Item extends Entity implements Observer {

    public int id;

    public Item(int x, int y){
        super(x,y);
    }

    public int getID() {
        return id;
    }
}

