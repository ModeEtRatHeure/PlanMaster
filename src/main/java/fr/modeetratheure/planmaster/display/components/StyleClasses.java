package fr.modeetratheure.planmaster.display.components;

public enum StyleClasses {

    CATEGORY_TITLE("category_title");

    private final String name;

    StyleClasses(String className){
        name = className;
    }

    public String getName(){
        return name;
    }

}
