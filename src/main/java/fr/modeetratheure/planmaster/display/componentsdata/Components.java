package fr.modeetratheure.planmaster.display.componentsdata;

public enum Components {

    CATEGORY("category"),
    OPTION_LIST("option-list"),
    OPTION("option");

    private final String path;

    Components(String name){
        path = "components/" + name + ".fxml";
    }

    public String path(){
        return path;
    }

}
