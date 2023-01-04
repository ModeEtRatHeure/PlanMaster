package fr.modeetratheure.planmaster.utils.saves.json;

import com.google.gson.stream.JsonWriter;
import javafx.scene.layout.Region;

import java.io.IOException;

abstract class RegionJsonObjectGenerator implements RegionJsonObject{

    protected JsonWriter jsonWriter;
    protected Region node;

    public RegionJsonObjectGenerator(JsonWriter jsonWriter, Region node){
        this.jsonWriter = jsonWriter;
        this.node = node;
    }

    public abstract void generate() throws IOException;

}
