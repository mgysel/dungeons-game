package unsw.dungeon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EndApplication {

    private Stage primaryStage;
    private EndController endController;
    private Scene endScene;

    
    public EndApplication(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        // Create new loader and controller
        endController = new EndController(primaryStage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EndGameView.fxml"));
        loader.setController(endController);
        Parent root = loader.load();
        endScene = new Scene(root);
        root.requestFocus();
    }

    public void endGame(String endMessage) {
        primaryStage.setTitle("End of Game");
        endController.setTitle(endMessage);
        primaryStage.setScene(endScene);
        primaryStage.show();
    }

}