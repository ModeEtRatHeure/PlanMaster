package fr.modeetratheure.planmaster.utils.saves;

import com.google.gson.Gson;
import fr.modeetratheure.planmaster.display.componentsdata.components.PlanningPreview;
import fr.modeetratheure.planmaster.utils.Helper;
import fr.modeetratheure.planmaster.utils.PMLogger;
import fr.modeetratheure.planmaster.utils.Static;
import fr.modeetratheure.planmaster.utils.saves.json.PlanningTypeAdapter;

import java.io.*;

public class SavesHandler {

    Gson gson;
    PMLogger logger;

    public SavesHandler(){
        gson = Static.getParameterizedWithTypeAdapterGson(PlanningPreview.class, new PlanningTypeAdapter());
        logger = new PMLogger(this.getClass());
    }

    public boolean save(PlanningPreview planning, String path){
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            logger.error("Could not save planning");
            return false;
        }
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
            bWriter.write(gson.toJson(planning));
            bWriter.close();
            return true;
        } catch (IOException e) {
            logger.error("Could not save planning");
            return false;
        }
    }

    public PlanningPreview load(String path){
        return gson.fromJson(Helper.readEntireFile(path), PlanningPreview.class);
    }

}
