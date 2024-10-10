package at.htlgkr.minigame;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import at.htlgkr.minigame.databinding.ActivityMainBinding;
import at.htlgkr.minigame.fragment.MemoryFragment;
import at.htlgkr.minigame.fragment.MenuFragment;
import at.htlgkr.minigame.fragment.GuessWordFragment;
import at.htlgkr.minigame.fragment.TicTacToeFragment;
import at.htlgkr.minigame.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.state.observe(this, state -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (state == MainViewModel.MENU){
                fragmentTransaction.add(R.id.main, new MenuFragment(), "MENU FRAGMENT");
            } else if (state == MainViewModel.MINI_GAME) {
                fragmentTransaction.replace(R.id.main, new GuessWordFragment(), "MINI GAME FRAGMENT");
                fragmentTransaction.addToBackStack("MENU FRAGMENT");
            }else if (state == MainViewModel.TIC_TAC_TOE){
                fragmentTransaction.replace(R.id.main, new TicTacToeFragment(), "TICTACTOE FRAGMENT");
                fragmentTransaction.addToBackStack("MENU FRAGMENT");
            }else if (state == MainViewModel.MEMORY){
                fragmentTransaction.replace(R.id.main, new MemoryFragment(), "MEMORY FRAGMENT");
                fragmentTransaction.addToBackStack("MENU FRAGMENT");
            }
            fragmentTransaction.commit();
        });
    }
}