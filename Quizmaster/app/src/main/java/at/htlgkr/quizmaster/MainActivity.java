package at.htlgkr.quizmaster;

import android.content.Context;
import android.content.res.loader.AssetsProvider;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import at.htlgkr.quizmaster.fragments.EndFragment;
import at.htlgkr.quizmaster.fragments.MenuFragment;
import at.htlgkr.quizmaster.fragments.QuizFragment;
import at.htlgkr.quizmaster.viewmodel.MainViewModel;

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
            if (state == MainViewModel.MENU){
                transaction.add(R.id.main, new MenuFragment(), "MENU FRAGMENT");
                transaction.replace(R.id.main, new MenuFragment(), "MENU FRAGMENT");
            }else if (state == MainViewModel.QUIZ){
                transaction.replace(R.id.main, new QuizFragment(), "QUIZ FRAGMENT");
            }else if (state == MainViewModel.END){
                transaction.replace(R.id.main, new EndFragment(), "END FRAGMENT");
            }
            transaction.commit();
        });
    }
}