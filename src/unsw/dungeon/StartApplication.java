package unsw.dungeon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApplication {

    private Stage startStage;
    private StartController startController;
    private Scene startScene;

    
    public StartApplication(Stage startStage) throws IOException {
        this.startStage = startStage;
        // Create new loader and controller
        startController = new StartController(startStage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
        loader.setController(startController);
        Parent root = loader.load();
        startScene = new Scene(root);
        root.requestFocus();
    }

    public void startGame() {
        startStage.setTitle("Start Game");
        startStage.setScene(startScene);
        startStage.show();
    }

}