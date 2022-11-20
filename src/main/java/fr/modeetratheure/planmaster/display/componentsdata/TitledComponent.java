package fr.modeetratheure.planmaster.display.componentsdata;

import javafx.beans.property.StringProperty;

public interface TitledComponent extends CustomComponent{

    public abstract String getText();

    public abstract void setText(String text);

    public abstract StringProperty textProperty();

}
