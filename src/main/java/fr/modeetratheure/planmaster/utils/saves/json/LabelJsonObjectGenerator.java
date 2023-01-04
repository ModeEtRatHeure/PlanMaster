package fr.modeetratheure.planmaster.utils.saves.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import javafx.scene.control.Label;

import java.io.IOException;

class LabelJsonObjectGenerator extends RegionJsonObjectGenerator{

    LabelJsonObjectGenerator(JsonWriter jsonWriter, Label node) {
        super(jsonWriter, node);
    }

    public void generate() throws IOException {
        jsonWriter.beginObject();
        doBasicWriterActions(jsonWriter, node);
        jsonWriter.name("text").value(((Label) node).getText());
        jsonWriter.endObject();
    }

    static Label read(JsonReader reader) throws IOException {
        Label label = new Label();
        reader.beginObject();
        while(reader.hasNext()){
            switch(reader.nextName()){
                case "prefHeight":
                    label.setPrefHeight(reader.nextInt());
                    break;
                case "prefWidth":
                    label.setPrefWidth(reader.nextInt());
                    break;
                case "styleClasses":
                    label.getStyleClass().setAll(reader.nextString().split(";"));
                    break;
                case "text":
                    label.setText(reader.nextString());
                    break;
            }
        }
        reader.endObject();
        return label;
    }

}
