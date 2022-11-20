package fr.modeetratheure.planmaster.display;

public enum Scenes {

    MAIN_SCENE("scenes/main-scene.fxml", true, 800, 500),
    PLANNING_DESIGN_SCENE("scenes/planning-design.fxml", true, 800, 500);

    private String scenePath;
    private boolean canBeResized;
    private int width, height;

    Scenes(String scenePath, boolean canBeResized, int width, int height){
        this.scenePath = scenePath;
        this.canBeResized = canBeResized;
        this.width = width;
        this.height = height;
    }

    public String path(){
        return scenePath;
    }

    public boolean canBeResized(){
        return canBeResized;
    }

    public int width(){
        return width;
    }

    public int height(){
        return height;
    }

}
