package fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class TextOption extends Option{

    private TextField textField;
    private EventHandler<ActionEvent> onAction;

    public TextOption(){
        super();
        textField = new TextField();
        setOptionType();
    }
    @Override
    public void setOptionType() {
        getChildren().add(textField);
    }

    public EventHandler<ActionEvent> getOnAction() {
        return onAction;
    }

    public void setOnAction(EventHandler<ActionEvent> onAction) {
        this.onAction = onAction;
        textField.setOnAction(this.onAction);
    }
}
