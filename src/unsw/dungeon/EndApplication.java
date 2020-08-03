package unsw.dungeon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EndApplication {

    private Stage endStage;
    private EndController endController;
    private Scene endScene;

    
    public EndApplication(Stage endStage) throws IOException {
        this.endStage = endStage;
        // Create new loader and controller
        endController = new EndController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EndGameView.fxml"));
        loader.setController(endController);
        Parent root = loader.load();
        endScene = new Scene(root);
        root.requestFocus();
    }

    public void endGame(String endMessage) {
        endStage.setTitle("End of Game");
        endController.setTitle(endMessage);
        endStage.setScene(endScene);
        endStage.show();
    }

}