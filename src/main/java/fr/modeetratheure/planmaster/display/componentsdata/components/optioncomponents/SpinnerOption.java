package fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class SpinnerOption extends Option{

    private Spinner<Integer> spinner;
    private int maxValue, minValue, defaultValue = 0;
    private boolean isEditable;

    public SpinnerOption(){
        super();
        spinner = new Spinner<Integer>();
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minValue, maxValue));
        setOptionType();
    }

    @Override
    public void setOptionType() {
        getChildren().add(spinner);
    }

    public int getDefaultValue(){
        return defaultValue;
    }

    public int getMinValue(){
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setDefaultValue(int defaultValue){
        this.defaultValue = defaultValue;
        spinner.getValueFactory().setValue(this.defaultValue);
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        updateSpinnerValueFactory();
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
        updateSpinnerValueFactory();
    }

    private void updateSpinnerValueFactory(){
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minValue, maxValue));
    }
}
