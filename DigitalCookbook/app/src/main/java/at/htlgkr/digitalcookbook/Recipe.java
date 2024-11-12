package at.htlgkr.digitalcookbook;

import java.util.List;

public class Recipe {
    private String name;
    private String ingrediants;
    private String preparaion;
    private int time;

    public Recipe(String name, String ingrediants, String preparaion, int time) {
        this.name = name;
        this.ingrediants = ingrediants;
        this.preparaion = preparaion;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngrediants() {
        return ingrediants;
    }

    public void setIngrediants(String ingrediants) {
        this.ingrediants = ingrediants;
    }

    public String getPreparaion() {
        return preparaion;
    }

    public void setPreparaion(String preparaion) {
        this.preparaion = preparaion;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
