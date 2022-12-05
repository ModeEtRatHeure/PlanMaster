package fr.modeetratheure.planmaster.utils;

import java.io.File;

public enum FilesPaths {

    LOGGER_FOLDER("logs"),
    SAVES_FOLDER("saves"),
    CONFIG_FOLDER("config");
    private static final String HOME_PATH = System.getProperty("os.name").toLowerCase().startsWith("windows") ? System.getenv("APPDATA") : System.getenv("home");

    public static final String FOLDER_APP_NAME = HOME_PATH + File.separator + "PlanMaster";

    private String name;

    FilesPaths(String name){
        this.name = name;
    }

    public String path(){
        return FOLDER_APP_NAME + File.separator + name;
    }

}
