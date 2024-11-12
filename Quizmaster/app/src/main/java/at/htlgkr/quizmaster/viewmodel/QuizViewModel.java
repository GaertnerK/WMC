package at.htlgkr.quizmaster.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.htlgkr.quizmaster.Category;
import at.htlgkr.quizmaster.Item;

public class QuizViewModel extends ViewModel {
    private List<Category> categories;
    private Item solution;
    public String message = "";

    public QuizViewModel() {
        this.categories = new ArrayList<>();
    }

    public void readFile(String filename, Context context) throws IOException {
        InputStream stream = context.getAssets().open(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        String line = reader.readLine();
        int categoryCounter = -1;
        categories.clear();
        while (line != null) {
            String[] parts = line.split(";");
            if (parts.length == 1){
                categories.add(new Category(parts[0]));
                categoryCounter++;
            }else {
                categories.get(categoryCounter).addItem(new Item(parts[0], new String[]{parts[1], parts[2], parts[3]}));
            }
            line = reader.readLine();
        }
    }

    public void setSolution(String name){
        Random random = new Random();
        categories.forEach(value -> {
            if (value.getName().equals(name)){
                solution = value.getRandomCategoryItems();
            }
        });
    }

    public Item getSolution() {
        return solution;
    }
}
