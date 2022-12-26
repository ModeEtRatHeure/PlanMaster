package fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents;

import javafx.scene.control.ChoiceBox;

public class ChoiceBoxOption extends Option{

    private ChoiceBox<String> choiceBox;

    public ChoiceBoxOption(){
        super();
        choiceBox = new ChoiceBox<>();
        setOptionType();
    }

    @Override
    public void setOptionType() {
        getChildren().add(choiceBox);
    }

    public String getItems(){
        return null;
    }

    public String getDefaultValue(){
        return null;
    }

    public void setItems(String items){
        for(String item:items.split(";")){
            choiceBox.getItems().add(item);
        }
    }

    public void setDefaultValue(String value){
        choiceBox.setValue(value);
    }

}
