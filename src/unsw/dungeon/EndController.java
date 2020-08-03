package unsw.dungeon;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * A JavaFX controller for the Conway's Game of Live Application.
 * Used to initialize UI elements in GameOfLife.fxml file
 *
 * @author Robert Clifton-Everest
 *
 */
public class EndController {
    @FXML
	private Label title;
    /**
     * Constructor for Game of Life controller
     * Insantiated in the fxml loader class in the application
     */
    public EndController() {
        // // Create new game
        // gameOfLife = new GameOfLife();
        // timeline = new Timeline();
    }

	public void setTitle(String endMessage) {
		title.setText(endMessage);
	}

    /**
     * Called when contents of fxml file are loaded
     * Allows for post-processing of content, including adding checkboxes
     */
    // @FXML
    // public void initialize() {
    //     // Add 100 instances of CheckBox to GridPane
    //     int i = 0;
    //     while (i < 10) {
    //         int j = 0;
    //         while (j < 10) {
    //             // Create JavaFX CheckBox, add to gridPane
    //             CheckBox checkbox = new CheckBox();
    //             gridPane.add(checkbox, i, j);
    //             // Binds checkbox select/unselect property to board in gameOfLife
    //             // Allows property to be modified by both user and code
    //             checkbox.selectedProperty().bindBidirectional(this.gameOfLife.cellProperty(i, j));
    //             j++;
    //         }
    //         i++;
    //     }
    // }
}