package unsw.dungeon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import unsw.dungeon.InteractionStrategyPattern.*;
import unsw.dungeon.ObstructionStrategyPattern.Wall;

import java.io.File;

/**
 * A DungeonLoader that also creates the necessary ImageViews for the UI,
 * connects them via listeners to the model, and creates a controller.
 * 
 * @author Robert Clifton-Everest
 *
 */
public class DungeonControllerLoader extends DungeonLoader {

    private List<ImageView> entities;

    // Images
    private Image playerImage;
    private Image wallImage;
    private Image exitImage;
    private Image treasureImage;
    private Image doorImage;
    private Image openDoorImage;
    private Image keyImage;
    private Image boulderImage;
    private Image floorSwitchImage;
    private Image portalImage;
    private Image enemyImage;
    private Image swordImage;
    private Image invincibilityPotionImage;
    private Image lavaImage;
    private Image trapImage;
    private Image bombImage;
    private Image bombExplodeImage;

    public DungeonControllerLoader(String filename) throws FileNotFoundException {
        super(filename);
        entities = new ArrayList<>();
        playerImage = new Image((new File("images/human_new.png")).toURI().toString());
        wallImage = new Image((new File("images/brick_brown_0.png")).toURI().toString());
        exitImage = new Image((new File("images/exit.png")).toURI().toString());
        treasureImage = new Image((new File("images/gold_pile.png")).toURI().toString());
        doorImage = new Image((new File("images/closed_door.png")).toURI().toString());
        openDoorImage = new Image((new File("images/open_door.png")).toURI().toString());
        keyImage = new Image((new File("images/key.png")).toURI().toString());
        boulderImage = new Image((new File("images/boulder.png")).toURI().toString());
        floorSwitchImage = new Image((new File("images/pressure_plate.png")).toURI().toString());
        portalImage = new Image((new File("images/portal.png")).toURI().toString());
        treasureImage = new Image((new File("images/gold_pile.png")).toURI().toString());
        enemyImage = new Image((new File("images/hound.png")).toURI().toString());
        swordImage = new Image((new File("images/greatsword_1_new.png")).toURI().toString());
        invincibilityPotionImage = new Image((new File("images/brilliant_blue_new.png")).toURI().toString());
        lavaImage = new Image((new File("images/lava.png")).toURI().toString());
        trapImage = new Image((new File("images/trap.png")).toURI().toString());
        bombImage = new Image((new File("images/bomb.png")).toURI().toString());
        bombExplodeImage = new Image((new File("images/bomb_explosion.png")).toURI().toString());
    }

    @Override
    public void onLoad(Entity player) {
        ImageView view = new ImageView(playerImage);
        addEntity(player, view);
    }

    @Override
    public void onLoad(Wall wall) {
        ImageView view = new ImageView(wallImage);
        addEntity(wall, view);
    }

    @Override
    public void onLoad(Exit exit) {
        ImageView view = new ImageView(exitImage);
        addEntity(exit, view);
    }

    @Override
    public void onLoad(Treasure treasure) {
        ImageView view = new ImageView(treasureImage);
        addEntity(treasure, view);
    }

    @Override
    public void onLoad(Door door) {
        ImageView view = new ImageView(doorImage);
        trackDoorOpen(door, view);
        addEntity(door, view);
    }

    @Override
    public void onLoad(Key key) {
        ImageView view = new ImageView(keyImage);
        addEntity(key, view);
    }

    @Override
    public void onLoad(Boulder boulder) {
        ImageView view = new ImageView(boulderImage);
        addEntity(boulder, view);
    }

    @Override
    public void onLoad(FloorSwitch floorSwitch) {
        ImageView view = new ImageView(floorSwitchImage);
        addEntity(floorSwitch, view);
    }

    @Override
    public void onLoad(Portal portal) {
        ImageView view = new ImageView(portalImage);
        addEntity(portal, view);
    }

    @Override
    public void onLoad(Enemy enemy) {
        ImageView view = new ImageView(enemyImage);
        addEntity(enemy, view);
    }

    @Override
    public void onLoad(Sword sword) {
        ImageView view = new ImageView(swordImage);
        addEntity(sword, view);
    }

    @Override
    public void onLoad(InvincibilityPotion invincibilityPotion) {
        ImageView view = new ImageView(invincibilityPotionImage);
        addEntity(invincibilityPotion, view);
    }

    @Override
    public void onLoad(Lava lava) {
        ImageView view = new ImageView(lavaImage);
        addEntity(lava,view);
    }

    @Override
    public void onLoad(Trap trap) {
        ImageView view = new ImageView(trapImage);
        addEntity(trap,view);
    }

    @Override
    public void onLoad(Bomb bomb) {
        ImageView view = new ImageView(bombImage);
        trackBombExplode(bomb, view);
        addEntity(bomb,view);
    }

    private void addEntity(Entity entity, ImageView view) {
        trackPosition(entity, view);
        view.setViewOrder(entity.getViewOrder());
        entities.add(view);
    }




    /**
     * Set a node in a GridPane to have its position track the position of an entity
     * in the dungeon.
     *
     * By connecting the model with the view in this way, the model requires no
     * knowledge of the view and changes to the position of entities in the model
     * will automatically be reflected in the view.
     * 
     * @param entity
     * @param node
     */
    private void trackPosition(Entity entity, Node node) {
        GridPane.setColumnIndex(node, entity.getX());
        GridPane.setRowIndex(node, entity.getY());
        entity.x().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                GridPane.setColumnIndex(node, newValue.intValue());
            }
        });
        entity.y().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                GridPane.setRowIndex(node, newValue.intValue());
            }
        });
        entity.doesExist().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                node.setVisible(newValue);
            }
        });
    }

    private void trackDoorOpen(Door door, Node node) {
        door.isOpen.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                ((ImageView) node).imageProperty().set(openDoorImage);
            }
        });
    }

    private void trackBombExplode(Bomb bomb, Node node) {
        bomb.didBombExplode.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                ((ImageView) node).imageProperty().set(bombExplodeImage);
            }
        });
    }




    /**
     * Create a controller that can be attached to the DungeonView with all the
     * loaded entities.
     * 
     * @return
     * @throws FileNotFoundException
     */
    public DungeonController loadController() throws FileNotFoundException {
        return new DungeonController(load(), entities);
    }


}
