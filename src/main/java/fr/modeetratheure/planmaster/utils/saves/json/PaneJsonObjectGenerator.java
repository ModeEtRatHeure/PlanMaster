package fr.modeetratheure.planmaster.utils.saves.json;

import com.google.gson.stream.JsonWriter;
import javafx.scene.layout.Pane;

import java.io.IOException;

class PaneJsonObjectGenerator extends RegionJsonObjectGenerator implements PaneJsonObject{

    PaneJsonObjectGenerator(JsonWriter jsonWriter, Pane pane){
        super(jsonWriter, pane);
    }

    @Override
    public void generate() throws IOException {
        jsonWriter.beginObject();
        doBasicWriterActions(jsonWriter, node);
        genChildrenObject(jsonWriter, (Pane) node);
        jsonWriter.endObject();
    }
}
