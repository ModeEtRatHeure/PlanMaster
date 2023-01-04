package fr.modeetratheure.planmaster.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Static {

    public static String join(List<String> list, String charh){
        StringBuilder builder = new StringBuilder();
        for(String str:list){
            builder.append(str + charh);
        }
        return builder.toString();
    }

    public static Gson getParameterizedWithTypeAdapterGson(Class clazz, Object typeAdapter){
        GsonBuilder gbuilder = new GsonBuilder();
        gbuilder.registerTypeAdapter(clazz, typeAdapter);
        gbuilder.setPrettyPrinting();
        return gbuilder.create();
    }
}
