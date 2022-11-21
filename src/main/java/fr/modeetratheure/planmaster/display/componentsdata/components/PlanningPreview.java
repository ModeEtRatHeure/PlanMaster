package fr.modeetratheure.planmaster.display.componentsdata.components;

import fr.modeetratheure.planmaster.display.componentsdata.Components;
import fr.modeetratheure.planmaster.display.componentsdata.CustomComponent;
import fr.modeetratheure.planmaster.display.componentsdata.StyleClasses;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlanningPreview extends HBox implements CustomComponent {

    private int numberOfDays = 7;

    public PlanningPreview(){
        initComponent(Components.PLANNING_PREVIEW.path());
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
        vbox.getStyleClass().add(StyleClasses.DAYS.getName());
        return vbox;
    }
}
