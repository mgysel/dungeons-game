package unsw.dungeon;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * EndController controls the end of game interface
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
        controller.startDungeon(primaryStage);
    }
    
	public void setTitle(String endMessage) {
		title.setText(endMessage);
	}
}