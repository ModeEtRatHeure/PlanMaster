package fr.modeetratheure.planmaster.display.componentsdata;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public interface CustomComponent {

    public default void initComponent(String path){
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(path));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
