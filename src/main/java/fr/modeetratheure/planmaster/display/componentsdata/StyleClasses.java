package fr.modeetratheure.planmaster.display.componentsdata;

public enum StyleClasses {

    CATEGORY_TITLE("category-title"),
    DAYS("days");

    private final String name;

    StyleClasses(String className){
        name = className;
    }

    public String getName(){
        return name;
    }

}
