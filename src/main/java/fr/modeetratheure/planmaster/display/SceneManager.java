package fr.modeetratheure.planmaster.display;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class SceneManager {

    private Stage stage;

    public SceneManager(Stage stage) throws IOException {
        this.stage = stage;
        setScene(Scenes.MAIN_SCENE);
    }

    public void setScene(Scenes scene) throws IOException {
        Scene tempScene = new Scene(FXMLLoader.load(Objects.requireNonNull(this.getClass().getClassLoader().getResource("scenes/main-scene.fxml"))), scene.width(), scene.height());
        stage.setScene(tempScene);
        stage.setResizable(scene.canBeResized());
    }

}
