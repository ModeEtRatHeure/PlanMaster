module fr.modeetratheure.planmaster {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.modeetratheure.planmaster to javafx.fxml;
    exports fr.modeetratheure.planmaster;
}