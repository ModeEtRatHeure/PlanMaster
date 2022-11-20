package fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents;

import javafx.scene.control.ColorPicker;

public class ColorPickerOption extends Option{

    private ColorPicker colorPicker;

    public ColorPickerOption(){
        super();
        setOptionType();
    }

    @Override
    public void setOptionType() {
        getChildren().add(new ColorPicker());
    }

}
