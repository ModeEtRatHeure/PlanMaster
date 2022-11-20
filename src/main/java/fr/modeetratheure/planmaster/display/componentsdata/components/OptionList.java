package fr.modeetratheure.planmaster.display.componentsdata.components;

import fr.modeetratheure.planmaster.display.componentsdata.Components;
import fr.modeetratheure.planmaster.display.componentsdata.CustomComponent;
import javafx.scene.layout.VBox;

public class OptionList extends VBox implements CustomComponent {

    public OptionList(){
        initComponent(Components.OPTION_LIST.path());
    }

}
