package fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents;

import fr.modeetratheure.planmaster.display.componentsdata.Components;
import fr.modeetratheure.planmaster.display.componentsdata.CustomComponent;
import fr.modeetratheure.planmaster.display.componentsdata.TitledComponent;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;

public abstract class Option extends HBox implements TitledComponent {

    @FXML
    private Label name;

    public Option(){
        initComponent(Components.OPTION.path());
    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(String text) {
        textProperty().set(text);
    }

    public StringProperty textProperty() {
        return name.textProperty();
    }

    public abstract void setOptionType();

}
