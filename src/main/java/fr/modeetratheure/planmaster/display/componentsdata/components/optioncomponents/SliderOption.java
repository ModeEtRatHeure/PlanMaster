package fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents;

import javafx.scene.control.Slider;

public class SliderOption extends Option{

    private Slider slider;
    private int defaultValue, maxValue, minValue, increment, minorTickUnit, majorTickUnit, blockIncrement;

    public SliderOption(){
        super();
        slider = new Slider();
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        setOptionType();
    }

    @Override
    public void setOptionType() {
        getChildren().add(slider);
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
        slider.setValue(this.defaultValue);
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        slider.setMax(this.maxValue);
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
        slider.setMin(this.minValue);
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
        slider.setBlockIncrement(this.increment);
    }

    public int getMinorTickUnit() {
        return minorTickUnit;
    }

    public void setMinorTickUnit(int minorTickUnit) {
        this.minorTickUnit = minorTickUnit;
        slider.setMinorTickCount(this.minorTickUnit);
    }

    public int getMajorTickUnit() {
        return majorTickUnit;
    }

    public void setMajorTickUnit(int majorTickUnit) {
        this.majorTickUnit = majorTickUnit;
        slider.setMajorTickUnit(this.majorTickUnit);
    }

    public int getBlockIncrement() {
        return blockIncrement;
    }

    public void setBlockIncrement(int blockIncrement) {
        this.blockIncrement = blockIncrement;
        slider.setBlockIncrement(this.blockIncrement);
    }
}
