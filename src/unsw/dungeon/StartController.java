package unsw.dungeon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartController {

    @FXML
    private Pane pane;
    @FXML
    private Button level1;
    @FXML
    private Button level2;
    @FXML
    private Button level3;

    Stage primaryStage;

    public StartController(Stage primaryStage) {
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
}
