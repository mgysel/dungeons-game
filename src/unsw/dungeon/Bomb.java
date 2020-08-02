package unsw.dungeon;

import java.util.List;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import unsw.dungeon.InteractionStrategyPattern.Enemy;

public class Bomb extends Entity {

    private int blastRange = 5;
    private int TTL;
    public BooleanProperty didBombExplode;
    private Dungeon dungeon;

    public Bomb(Dungeon dungeon, int x, int y) {
        super(x,y);
        this.dungeon = dungeon;
        this.didBombExplode = new SimpleBooleanProperty(false);
        Random rand = new Random();
        this.TTL = rand.nextInt(30);
        startTimer();
    }

    private void startTimer() {
        Timeline explodeTimeline = new Timeline();
        Bomb thisBomb = this;

        EventHandler<ActionEvent> detonate = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                List<Entity> entities = dungeon.getEntities();
                for (Entity entity : entities) {
                    Double distance = Math.sqrt(Math.pow(entity.getX() - getX(), 2) + Math.pow(entity.getY() - getY(), 2));
                    if (distance < blastRange + 1) {
                        killEntity(entity);
                        thisBomb.didBombExplode.set(true);
                    }
                }
            }
        };
        System.out.println("TTL: " + TTL);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(TTL), detonate); 
        explodeTimeline.getKeyFrames().add(keyFrame);
        explodeTimeline.setCycleCount(1);
        explodeTimeline.play();

        Timeline removeBombTimeline = new Timeline();

        // Remove bomb after 2 seconds
        EventHandler<ActionEvent> removeBomb = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                thisBomb.doesExist().set(false);
            }
        };

        KeyFrame removeBombKeyFrame = new KeyFrame(Duration.seconds(2+TTL), removeBomb); 
        removeBombTimeline.getKeyFrames().add(removeBombKeyFrame);
        removeBombTimeline.setCycleCount(1);
        removeBombTimeline.play();

    }

    private void killEntity(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.dies();
        } else if (entity instanceof Enemy) {
            Enemy enemy = (Enemy) entity;
            enemy.dies();
        }
    }


}