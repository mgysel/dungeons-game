package unsw.dungeon;

import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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
    @FXML
    private Button level1;
    @FXML
    private Button level2;
    @FXML
    private Button level3;

    Stage primaryStage;

    public EndController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void load1(ActionEvent event) throws IOException {
        changeToDungeon("maze.json");
    }

    @FXML
    public void load2(ActionEvent event) throws IOException {
        changeToDungeon("advanced.json");
    }

    @FXML
    public void load3(ActionEvent event) throws IOException {
        changeToDungeon("advanced2.json");
    }

    private void changeToDungeon(String dungeonName) throws IOException {
        primaryStage.setTitle("Dungeon");
        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader(dungeonName);
        DungeonController controller = dungeonLoader.loadController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
	public void setTitle(String endMessage) {
		title.setText(endMessage);
	}
}