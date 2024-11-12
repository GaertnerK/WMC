package at.htlgkr.digitalcookbook;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import at.htlgkr.digitalcookbook.fragments.AddRecipeFragment;
import at.htlgkr.digitalcookbook.fragments.NoRecipeIncludedFragment;
import at.htlgkr.digitalcookbook.fragments.RecipesIncludedFragment;
import at.htlgkr.digitalcookbook.fragments.RecipesOverviewFragment;
import at.htlgkr.digitalcookbook.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.state.observe(this, state -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (state == MainViewModel.firstPage){
                if (IOHandler.read(getApplicationContext()) == null) {
                    transaction.add(R.id.main, new NoRecipeIncludedFragment(), "NO RECIPE INCLUDED FRAGMENT");
                    transaction.replace(R.id.main, new NoRecipeIncludedFragment(), "NO RECIPE INCLUDED FRAGMENT");
                }else {
                    transaction.add(R.id.main, new RecipesIncludedFragment(), "RECIPES INCLUDED FRAGMENT");
                    transaction.replace(R.id.main, new RecipesIncludedFragment(), "RECIPES INCLUDED FRAGMENT");
                }
            }else if (state == MainViewModel.addRecipe){
                transaction.replace(R.id.main, new AddRecipeFragment(), "ADD RECIPE FRAGMENT");
            }else if (state == MainViewModel.recipesOverview){
                transaction.replace(R.id.main, new RecipesOverviewFragment(), "RECIPES OVERVIEW FRAGMENT");
            }
            transaction.commit();
        });
    }
}