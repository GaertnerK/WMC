package at.htlgkr.mychristmasapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import at.htlgkr.mychristmasapp.fragments.LetterFragment;
import at.htlgkr.mychristmasapp.fragments.MainScreenFragment;
import at.htlgkr.mychristmasapp.fragments.WelcomeFragment;
import at.htlgkr.mychristmasapp.fragments.WishesFragment;
import at.htlgkr.mychristmasapp.fragments.WreathFragment;
import at.htlgkr.mychristmasapp.viewmodel.MainViewModel;

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

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.state.observe(this, state -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (state == MainViewModel.WELCOME_SCREEN){
                transaction.add(R.id.main, new WelcomeFragment());
                transaction.replace(R.id.main, new WelcomeFragment());
            }else if (state == MainViewModel.MAIN_SCREEN){
                transaction.replace(R.id.main, new MainScreenFragment());
                transaction.addToBackStack("Welcome Screen");
            }else if (state == MainViewModel.WREATH_SCREEN) {
                transaction.replace(R.id.main, new WreathFragment());
                transaction.addToBackStack("Main Screen");
            }else if (state == MainViewModel.WISHES_SCREEN){
                transaction.replace(R.id.main, new WishesFragment());
                transaction.addToBackStack("Main Screen");
            }else if (state == MainViewModel.LETTER_SCREEN){
                transaction.replace(R.id.main, new LetterFragment());
                transaction.addToBackStack("Main Screen");
            }
            transaction.commit();
        });
    }
}