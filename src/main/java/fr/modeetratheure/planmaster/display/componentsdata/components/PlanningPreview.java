package fr.modeetratheure.planmaster.display.componentsdata.components;

import fr.modeetratheure.planmaster.display.componentsdata.Components;
import fr.modeetratheure.planmaster.display.componentsdata.CustomComponent;
import fr.modeetratheure.planmaster.display.componentsdata.StyleClasses;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlanningPreview extends HBox implements CustomComponent {

    private int numberOfDays = 7;

    public PlanningPreview(){
        initComponent(Components.PLANNING_PREVIEW.path());
        setSpacing(20);
        setAlignment(Pos.CENTER);
        setMinHeight(250);
        setMaxHeight(500);
        setPrefWidth(500);
        setPrefHeight(400);
        System.out.println(getPrefWidth()+"tet");
        addDays(numberOfDays);
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        int number = Math.abs(numberOfDays - this.numberOfDays);
        if(numberOfDays > this.numberOfDays){
            addDays(number);
        }else{
            removeDays(number);
        }
        this.numberOfDays = numberOfDays;
    }

    public void setDaysSpacing(int spacing){
        setSpacing(spacing);
    }

    private void addDays(int numberOfDays){
        for(int i = 0; i < numberOfDays; i++){
            getChildren().add(addDay());
        }
    }

    private void removeDays(int numberOfDays){
        for(int i = 1; i < numberOfDays + 1; i++){
            getChildren().remove(getChildren().size() - i);
        }
    }

    private VBox addDay(){
        VBox vbox = new VBox();
        vbox.setPrefWidth(Math.abs(getPrefHeight()) - ((numberOfDays + 1) * getSpacing()));
        System.out.println(Math.abs(getPrefHeight()));
        System.out.println(3 * Math.abs(getPrefHeight())/4);
        vbox.setMaxHeight(4 * Math.abs(getPrefHeight())/5);
        vbox.getStyleClass().add(StyleClasses.DAYS.getName());
        return vbox;
    }
}
