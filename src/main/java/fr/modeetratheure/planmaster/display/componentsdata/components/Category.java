package fr.modeetratheure.planmaster.display.componentsdata.components;

import fr.modeetratheure.planmaster.display.componentsdata.Components;
import fr.modeetratheure.planmaster.display.componentsdata.CustomComponent;
import fr.modeetratheure.planmaster.display.componentsdata.TitledComponent;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Category extends VBox implements TitledComponent {

    @FXML
    private Label title;

    public Category(){
        initComponent(Components.CATEGORY.path());
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
