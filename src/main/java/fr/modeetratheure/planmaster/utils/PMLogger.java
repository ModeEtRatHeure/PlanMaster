package fr.modeetratheure.planmaster.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class PMLogger {

    private final String defaultFileName = FilesPaths.LOGGER_FOLDER.path() + File.separator + "PMlogs.log";
    private Logger logger;

    public PMLogger(Class<?> clazz){
        logger = Logger.getLogger(clazz.getSimpleName());
        try {
            FileHandler handler = new FileHandler(defaultFileName);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
        } catch (IOException e) {
            logger.severe("Failed to setup default log file");
        }
    }

    public void info(String message){
        logger.info(message);
    }

    public void warn(String message){
        logger.warning(message);
    }

    public void error(String message){
        logger.severe(message);
    }

}
