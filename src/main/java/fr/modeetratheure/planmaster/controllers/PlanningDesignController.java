package fr.modeetratheure.planmaster.controllers;

import fr.modeetratheure.planmaster.display.componentsdata.components.PlanningPreview;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;

import java.net.MalformedURLException;

public class PlanningDesignController {

    @FXML
    PlanningPreview planning;

    @FXML
    public void setDaysSpacing(int spacing){
        planning.setDaysSpacing(spacing);
    }

    @FXML
    public void browseImageForBg() throws MalformedURLException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choisir une image");
        try{
            Image img = new Image(chooser.showOpenDialog(null).toURI().toURL().toExternalForm());
            Background bg = new Background(new BackgroundImage(
                    img,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT
            ));
            planning.setBackground(bg);
            planning.setPrefHeight(img.getHeight());
        }catch(NullPointerException e){
            //TODO: ajouter un message dans les logs
        }
    }

    @FXML
    public void createEvent(){
        //TODO: impl
    }

}
