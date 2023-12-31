package unsw.dungeon.InteractionStrategyPattern;

// import unsw.dungeon.EnemyStatePattern.EnemyState;
// import unsw.dungeon.EnemyStatePattern.ScaredState;
// import unsw.dungeon.EnemyStatePattern.NormalState;

import unsw.dungeon.Dungeon;
import unsw.dungeon.EnemyStatePattern.EnemyState;
import unsw.dungeon.EnemyStatePattern.NotScaredEnemyState;
import unsw.dungeon.EnemyStatePattern.ScaredEnemyState;
import unsw.dungeon.Entity;
import unsw.dungeon.LayerEnum;
import unsw.dungeon.ObserverPattern.Observer;
import unsw.dungeon.Player;
import unsw.dungeon.PlayerStatePattern.Invincible;
import unsw.dungeon.LayerEnum;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Enemy extends Entity implements Observer, Interaction {

    private Dungeon dungeon;
    private EnemyState scaredState;
    private EnemyState notScaredState;
    private EnemyState state;
    private Timeline timeline;

    public Enemy(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.viewOrder().set(LayerEnum.ENEMYBOULDER.getZIndex());
        this.dungeon = dungeon;
        scaredState = new ScaredEnemyState(this);
        notScaredState = new NotScaredEnemyState(this);
        this.state = notScaredState;
    }

    public void moveEnemy(Player player, Dungeon dungeon) {
        timeline = new Timeline();
        EventHandler<ActionEvent> move = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                state.moveEnemy(player, dungeon);
                int thisEnemyX = Enemy.super.getX();
                int thisEnemyY = Enemy.super.getY();
                for (Entity entity : dungeon.getEntities(thisEnemyX, thisEnemyY)) {
                    if (entity instanceof Enemy) {
                        // do nothing
                    } else {
                        performInteraction(entity);
                    }
                }
            }
        };

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), move); 

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @Override
    public void update(Player player) {
        // If player is invincible, change state to scared
        if (player.getState() instanceof Invincible) {
            this.state = scaredState;
        } else {
            // If player does not have invincible, change state to not scared
            this.state = notScaredState;
        }
    }

    @Override
    public void performInteraction(Entity entity) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            state.performInteraction(player);
        } else if (entity instanceof Portal) {
            ((Portal) entity).performInteraction(this);
        } else if (entity instanceof Lava) {
            ((Lava) entity).performInteraction(this);
        } else if (entity instanceof Trap) {
            ((Trap) entity).performInteraction(this);
        }
    }

    public EnemyState getState() {
        return this.state;
    }

    public void dies() {
        doesExist().set(false);
        timeline.stop();
        dungeon.removeEntity(this);
    }

    
}