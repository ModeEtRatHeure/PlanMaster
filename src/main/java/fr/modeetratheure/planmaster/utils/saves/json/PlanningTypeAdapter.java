package fr.modeetratheure.planmaster.utils.saves.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.modeetratheure.planmaster.display.componentsdata.components.PlanningPreview;

import java.io.IOException;

public class PlanningTypeAdapter extends TypeAdapter<PlanningPreview> implements RegionJsonObject, PaneJsonObject{

    @Override
    public void write(JsonWriter jsonWriter, PlanningPreview planningPreview) throws IOException {
        jsonWriter.beginObject();
        doBasicWriterActions(jsonWriter, planningPreview);
        genChildrenObject(jsonWriter, planningPreview);
        jsonWriter.endObject();
    }

    @Override
    public PlanningPreview read(JsonReader jsonReader) throws IOException {
        PlanningPreview planningPreview = new PlanningPreview();
        planningPreview.getChildren().clear();
        readMe(jsonReader, planningPreview);
        return planningPreview;
    }
}
