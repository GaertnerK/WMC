package at.htlgkr.kiliangaertner;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import at.htlgkr.kiliangaertner.fragments.CookieDesignerFragment;
import at.htlgkr.kiliangaertner.fragments.OverviewFragment;
import at.htlgkr.kiliangaertner.fragments.ProfilFragment;
import at.htlgkr.kiliangaertner.fragments.QuizEndFragment;
import at.htlgkr.kiliangaertner.fragments.QuizFragment;
import at.htlgkr.kiliangaertner.viewmodel.MainViewModel;

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
            if (state == MainViewModel.OVERVIEW_SCREEN){
                transaction.add(R.id.main, new OverviewFragment());
                transaction.replace(R.id.main, new OverviewFragment());
            } else if (state == MainViewModel.PROFILE_SCREEN) {
                transaction.replace(R.id.main, new ProfilFragment());
                transaction.addToBackStack("OVERVIEW");
            } else if (state == MainViewModel.COOKIE_SCREEN) {
                transaction.replace(R.id.main, new CookieDesignerFragment());
                transaction.addToBackStack("OVERVIEW");
            } else if (state == MainViewModel.QUIZ_SCREEN) {
                transaction.replace(R.id.main, new QuizFragment());
                transaction.addToBackStack("OVERVIEW");
            } else if (state == MainViewModel.QUIZ_END_SCREEN) {
                transaction.replace(R.id.main, new QuizEndFragment());
            }
            transaction.commit();
        });
    }
}