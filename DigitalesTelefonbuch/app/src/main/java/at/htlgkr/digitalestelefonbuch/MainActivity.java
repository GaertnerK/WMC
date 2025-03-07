package at.htlgkr.digitalestelefonbuch;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import at.htlgkr.digitalestelefonbuch.fragments.AddNumberFragment;
import at.htlgkr.digitalestelefonbuch.fragments.ListOverviewFragment;
import at.htlgkr.digitalestelefonbuch.fragments.MenuFragment;
import at.htlgkr.digitalestelefonbuch.fragments.NoNumberFragment;
import at.htlgkr.digitalestelefonbuch.viewmodels.MainViewModel;

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
            if (state == MainViewModel.FIRST_PAGE){
                if (IOHandler.read(getApplicationContext()) == null){
                    transaction.add(R.id.main, new NoNumberFragment());
                    transaction.replace(R.id.main, new NoNumberFragment());
                }else{
                    transaction.add(R.id.main, new MenuFragment());
                    transaction.replace(R.id.main, new MenuFragment());
                }
            }else if (state == MainViewModel.ADD_NUMBER){
                transaction.replace(R.id.main, new AddNumberFragment());
                transaction.addToBackStack("Menu");
            } else if (state == MainViewModel.NUMBERS_OVERVIEW) {
                transaction.replace(R.id.main, new ListOverviewFragment());
                transaction.addToBackStack("Menu");
            }
            transaction.commit();
        });
    }
}