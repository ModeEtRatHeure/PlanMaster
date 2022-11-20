module fr.modeetratheure.planmaster {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.modeetratheure.planmaster to javafx.fxml;
    opens fr.modeetratheure.planmaster.display.componentsdata to javafx.fxml;
    exports fr.modeetratheure.planmaster.display.componentsdata;
    exports fr.modeetratheure.planmaster;
    exports fr.modeetratheure.planmaster.display.componentsdata.components;
    opens fr.modeetratheure.planmaster.display.componentsdata.components to javafx.fxml;
    exports fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents;
    opens fr.modeetratheure.planmaster.display.componentsdata.components.optioncomponents to javafx.fxml;
}