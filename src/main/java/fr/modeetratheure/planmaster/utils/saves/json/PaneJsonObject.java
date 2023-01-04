package fr.modeetratheure.planmaster.utils.saves.json;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface PaneJsonObject {

    default void genChildrenObject(JsonWriter writer, Pane pane) throws IOException {
        writer.name("children");
        writer.beginObject();
        for(Node node:pane.getChildren()){
            if(node instanceof Region){
                if(node instanceof Pane){
                    writer.name(node.getClass().getName());
                    new PaneJsonObjectGenerator(writer, (Pane) node).generate();
                }else if(node instanceof Label){
                    writer.name(node.getClass().getName());
                    new LabelJsonObjectGenerator(writer, ((Label) node)).generate();
                }else{
                    PMJsonLogging.warn("Found an unexpected node while saving, skipped it.");
                }
            }else{
                if(node instanceof ImageView){
                    writer.name(node.getClass().getName()).value(((ImageView) node).getImage().getUrl());
                }else{
                    PMJsonLogging.warn("Found an unexpected node while saving, skipped it.");
                }
            }
        }
        writer.endObject();
    }

    default void readMe(JsonReader jsonReader, Pane pane) throws IOException {
        jsonReader.beginObject();
        while(jsonReader.hasNext()){
            try{
                switch(jsonReader.nextName()){
                    case "prefHeight":
                        pane.setPrefHeight(jsonReader.nextInt());
                        break;
                    case "prefWidth":
                        pane.setPrefWidth(jsonReader.nextInt());
                        break;
                    case "styleClasses":
                        pane.getStyleClass().setAll(jsonReader.nextString().split(";"));
                        break;
                    case "children":
                        pane.getChildren().setAll(readChildren(jsonReader));
                        break;
                }
            }catch(JsonSyntaxException e){
                jsonReader.nextString();
            }
        }
        jsonReader.endObject();
    }

    default List<Node> readChildren(JsonReader jsonReader) throws IOException {
        List<Node> children = new ArrayList<>();
        jsonReader.beginObject();
        while(jsonReader.hasNext()){
            Class<Node> clazz;
            try {
                clazz = (Class<Node>) Class.forName(jsonReader.nextName());
                if(clazz.equals(Label.class)){
                    children.add(LabelJsonObjectGenerator.read(jsonReader));
                }else if(clazz.equals(ImageView.class)){
                    ImageView imgv = new ImageView();
                    imgv.setImage(new Image(jsonReader.nextString()));
                    children.add(imgv);
                }else if(clazz.equals(HBox.class) || clazz.equals(VBox.class)){
                    Pane pane = (Pane)clazz.newInstance();
                    readMe(jsonReader, pane);
                    children.add(pane);
                }else{
                    PMJsonLogging.warn("Found an unknown node among a pane children, skipped it.");
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                PMJsonLogging.error("Failed to load a pane child.");
            }
        }
        jsonReader.endObject();
        return children;
    }

}
