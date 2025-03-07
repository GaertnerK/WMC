package at.htlgkr.digitalcookbook.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import at.htlgkr.digitalcookbook.IOHandler;
import at.htlgkr.digitalcookbook.Recipe;

public class LogicViewModel extends ViewModel {
    private List<Recipe> recipes;
    public List<Recipe> filterdRecipes;

    public static boolean filter = false;
    public static boolean edit = false;
    public static int index = 0;

    public LogicViewModel() {
        this.recipes = new ArrayList<>();
        this.filterdRecipes = new ArrayList<>();
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public Recipe getRecipe(int index){
        return recipes.get(index);
    }

    public void addRecipe(Recipe recipe){
        if (edit){
            recipes.set(index, recipe);
        }else {
            recipes.add(recipe);
        }
    }

    public void clearRecipes(){
        recipes = new ArrayList<>();
    }

    public void safeRecipes(Context context){
        Gson gson = new Gson();
        String s = gson.toJson(recipes);
        IOHandler.write(context, s);
    }

    public void loadRecipes(Context context){
        Gson gson = new Gson();
        String s = IOHandler.read(context);
        TypeToken<List<Recipe>> typeToken = new TypeToken<List<Recipe>>() {};
        recipes = gson.fromJson(s, typeToken);
    }

    public void loadFilteredRecipes(){
        recipes = filterdRecipes;
    }
}
