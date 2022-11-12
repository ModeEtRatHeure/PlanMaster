package fr.modeetratheure.planmaster.display;

import javafx.stage.Stage;

import java.io.IOException;

public class PMStage {

    private Stage stage;
    private SceneManager sceneManager;

    public PMStage(Stage stage, String title) throws IOException {
        this.stage = stage;
        this.stage.setTitle(title);
        sceneManager = new SceneManager(this.stage);
        stage.centerOnScreen();
        this.stage.show();
    }

    public SceneManager sceneManager(){
        return sceneManager;
    }

}
