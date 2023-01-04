package fr.modeetratheure.planmaster.utils;

import java.io.*;
import java.lang.reflect.Field;

public class Helper {

    private static File appFolder, loggerFolder, configFolder, savesFolder;
    private static PMLogger logger;

    public static void init(){
        logger = new PMLogger(Helper.class);
        generateAppFolder();
    }

    public static File createFile(String fileName, String parentFolder){
        Field folderField;
        File file = null;
        try {
            folderField = Helper.class.getDeclaredField(parentFolder + "Folder");
            if(!folderField.getType().equals(File.class)){
                //On veut que ce soit forcément un field de type File donc on rentre aussi dans le catch
                throw new NoSuchFieldException();
            }
        } catch (NoSuchFieldException e) {
            try {
                //En cas de problème, on crée le fichier a partir du appFolder
                file = new File(appFolder.toPath() + File.separator + fileName);
                file.createNewFile();
                return file;
            } catch (IOException ex) {
                logger.error("Failed to create file " + fileName);
                return null;
            }
        }
        //Si tout s'est bien passé, on crée le fichier à partir du path contenu dans le field du folder spécifié
        try {
            file = new File(folderField.get("") + File.separator + fileName);
            file.createNewFile();
        } catch (IllegalAccessException e) {
            logger.error("Internal Error, could not create file " + fileName);
        } catch (IOException e) {
            logger.error("Failed to create file " + fileName);
            return null;
        }
        return file;
    }

    public static String readEntireFile(String path){
        BufferedReader bReader;
        try {
            bReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            logger.error("Failed to load planning at " + path);
            return null;
        }
        String currentLine;
        StringBuilder sBuilder = new StringBuilder();
        try{
            while((currentLine = bReader.readLine()) != null){
                sBuilder.append(currentLine).append("\n");
            }
        }catch(IOException e){
            logger.error("Failed to load planning at " + path);
            return null;
        }
        return sBuilder.toString();
    }

    private static void generateAppFolder(){
        appFolder = new File(FilesPaths.FOLDER_APP_NAME);
        appFolder.mkdir();
        generateChildrenFolder();
    }

    private static void generateChildrenFolder(){
        savesFolder = new File(FilesPaths.SAVES_FOLDER.path());
        configFolder = new File(FilesPaths.CONFIG_FOLDER.path());
        loggerFolder = new File(FilesPaths.LOGGER_FOLDER.path());

        savesFolder.mkdir();
        loggerFolder.mkdir();
        configFolder.mkdir();
    }

}
