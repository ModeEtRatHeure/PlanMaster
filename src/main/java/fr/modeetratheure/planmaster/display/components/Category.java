package fr.modeetratheure.planmaster.display.components;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Category extends VBox {

    @FXML
    private Label title;

    public Category(){
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("components/category.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText(){
        return textProperty().get();
    }

    public void setText(String text){
        textProperty().set(text);
    }

    public StringProperty textProperty(){
        return title.textProperty();
    }

}
