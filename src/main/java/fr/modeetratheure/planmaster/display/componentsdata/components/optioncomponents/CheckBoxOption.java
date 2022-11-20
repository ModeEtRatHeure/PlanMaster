package fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents;

import javafx.scene.control.CheckBox;

public class CheckBoxOption extends Option{

    private CheckBox checkBox;
    private boolean isChecked;

    public CheckBoxOption(){
        super();
        checkBox = new CheckBox();
        setOptionType();
    }

    @Override
    public void setOptionType() {
        getChildren().add(checkBox);
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean checked) {
        isChecked = checked;
        checkBox.setSelected(isChecked);
    }
}
