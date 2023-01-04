package fr.modeetratheure.planmaster.utils.saves.json;

import com.google.gson.stream.JsonWriter;
import fr.modeetratheure.planmaster.utils.Static;
import javafx.scene.layout.Region;

import java.io.IOException;

interface RegionJsonObject {

    default void doBasicWriterActions(JsonWriter writer, Region node) throws IOException {
        writer.name("prefHeight").value(node.getPrefHeight());
        writer.name("prefWidth").value(node.getPrefWidth());
        writer.name("styleClasses").value(Static.join(node.getStyleClass(), ";"));
    }

}
