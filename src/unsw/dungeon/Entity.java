package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * An entity in the dungeon.
 * 
 * @author Robert Clifton-Everest
 *
 */
public class Entity {

    // IntegerProperty is used so that changes to the entities position can be
    // externally observed.
    private IntegerProperty x, y;
    private BooleanProperty doesExist;
    private DoubleProperty viewOrder;

    /**
     * Create an entity positioned in square (x,y)
     * 
     * @param x
     * @param y
     * @param doesExist
     */
    public Entity(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.doesExist = new SimpleBooleanProperty(true);
        this.viewOrder = new SimpleDoubleProperty();
    }

    public IntegerProperty x() {
        return x;
    }

    public IntegerProperty y() {
        return y;
    }

    public BooleanProperty doesExist() {
        return doesExist;
    }

    public DoubleProperty viewOrder() {
        return viewOrder;
    }

    public int getY() {
        return y().get();
    }

    public int getX() {
        return x().get();
    }

    public boolean getDoesExist() {
        return doesExist().get();
    }

    public double getViewOrder() {
        return viewOrder().get();
    }

}
