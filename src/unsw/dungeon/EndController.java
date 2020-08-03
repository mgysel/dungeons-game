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
import javafx.scene.control.TextField;
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
	private TextField title;
    /**
     * Constructor for Game of Life controller
     * Insantiated in the fxml loader class in the application
     */
    public EndController() {

    }

	public void setTitle(String endMessage) {
		title.setText(endMessage);
	}
}