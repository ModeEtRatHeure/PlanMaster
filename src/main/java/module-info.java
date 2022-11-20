module fr.modeetratheure.planmaster {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.modeetratheure.planmaster to javafx.fxml;
    opens fr.modeetratheure.planmaster.display.components to javafx.fxml;
    exports fr.modeetratheure.planmaster.display.components;
    exports fr.modeetratheure.planmaster;
}