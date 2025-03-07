package at.htlgkr.wmc1plfuebung;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import at.htlgkr.wmc1plfuebung.fragments.LetterFragment;
import at.htlgkr.wmc1plfuebung.fragments.MainFragment;
import at.htlgkr.wmc1plfuebung.fragments.WelcomeFragment;
import at.htlgkr.wmc1plfuebung.fragments.WishesFragment;
import at.htlgkr.wmc1plfuebung.fragments.WreathFragment;
import at.htlgkr.wmc1plfuebung.viewmodels.MainViewModel;

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
            if (state == MainViewModel.WELCOME_SCREEN){
                transaction.add(R.id.main, new WelcomeFragment());
                transaction.replace(R.id.main, new WelcomeFragment());
            }else if (state == MainViewModel.MAIN_SCREEN){
                transaction.replace(R.id.main, new MainFragment());
                transaction.addToBackStack("Welcome");
            }else if (state == MainViewModel.WISHES_SCEEN){
                transaction.replace(R.id.main, new WishesFragment());
                transaction.addToBackStack("Main");
            }else if (state == MainViewModel.WREATH_SCREEN){
                transaction.replace(R.id.main, new WreathFragment());
                transaction.addToBackStack("Main");
            }else if (state == MainViewModel.LETTER_SCREEN){
                transaction.replace(R.id.main, new LetterFragment());
                transaction.addToBackStack("Main");
            }
            transaction.commit();
        });
    }
}