package at.htlgkr.digitalcookbook.viewmodel;

import android.app.appsearch.AppSearchManager;
import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import at.htlgkr.digitalcookbook.IOHandler;
import at.htlgkr.digitalcookbook.R;
import at.htlgkr.digitalcookbook.Recipe;

public class LogicViewModel extends ViewModel {
    List<Recipe> recipes;

    public LogicViewModel() {
        this.recipes = new ArrayList<>();
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public Recipe getRecipe(int index){
        return recipes.get(index);
    }

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }

    public void safeRecipes(Context context){
        Gson gson = new Gson();
        String s = gson.toJson(recipes);
        IOHandler.write(context, s);
    }

    public void loadRecipes(Context context){
        Gson gson = new Gson();
        String s = IOHandler.read(context);
        TypeToken<List<Recipe>> typeToken = new TypeToken<List<Recipe>>(){};
        recipes = gson.fromJson(s, typeToken);
    }
}
