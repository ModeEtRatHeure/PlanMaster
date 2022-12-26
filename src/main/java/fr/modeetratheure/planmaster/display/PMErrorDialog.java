package fr.modeetratheure.planmaster.display;

import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

public class PMErrorDialog {

    public PMErrorDialog(String message){
        Stage stage = new Stage();
        DialogPane root = new DialogPane();
        root.setContentText(message);
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
    }

}
