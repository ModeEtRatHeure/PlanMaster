package fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents;

import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonOption extends Option{

    private Button button;
    private String buttonName;
    private EventHandler<javafx.event.ActionEvent> onAction;

    public ButtonOption(){
        super();
        button = new Button();
    }

    public String getButtonName(){
        return buttonName;
    }

    public void setButtonName(String name){
        buttonName = name;
        button.setText(buttonName);
        setOptionType();
    }

    public EventHandler<javafx.event.ActionEvent> getOnAction(){
        return onAction;
    }

    public void setOnAction(EventHandler<javafx.event.ActionEvent> action){
        onAction = action;
        button.setOnAction(action);
    }

    @Override
    public void setOptionType() {
        getChildren().add(button);
    }
}
