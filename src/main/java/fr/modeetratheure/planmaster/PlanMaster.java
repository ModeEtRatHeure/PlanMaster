package fr.modeetratheure.planmaster;

import fr.modeetratheure.planmaster.display.PMStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class PlanMaster extends Application {

    PMStage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = new PMStage(primaryStage, "PlanMaster");
    }
}
