package at.htlgkr.hangman;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import at.htlgkr.hangman.databinding.ActivityMainBinding;
import at.htlgkr.hangman.fragments.GameFragment;
import at.htlgkr.hangman.fragments.MenuFragment;
import at.htlgkr.hangman.fragments.PlayerComputerFragment;
import at.htlgkr.hangman.fragments.PlayerPlayerFragment;
import at.htlgkr.hangman.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainViewModel model = new ViewModelProvider(this).get(MainViewModel.class);

        model.state.observe(this, state -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (state == MainViewModel.MENU){
                transaction.add(R.id.main, new MenuFragment(), "MENU FRAGMENT");
            } else if(state == MainViewModel.PLAYERVSPLAYER){
                transaction.replace(R.id.main, new PlayerPlayerFragment(), "PLAYER VS PLAYER FRAGMENT");
                transaction.addToBackStack("MENU FRAGMENT");
            }else if(state == MainViewModel.PLAYERVSCOMPUTER){
                transaction.replace(R.id.main, new PlayerComputerFragment(), "PLAYER VS COMPUTER FRAGMENT");
                transaction.addToBackStack("MENU FRAGMENT");
            }else if (state == MainViewModel.GAME){
                transaction.replace(R.id.main, new GameFragment(), "GAME FRAGMENT");
                transaction.addToBackStack("PLAYER VS COMPUTER FRAGMENT");
            }
            transaction.commit();
        });
    }
}