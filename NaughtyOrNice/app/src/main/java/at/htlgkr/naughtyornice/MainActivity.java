package at.htlgkr.naughtyornice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import at.htlgkr.naughtyornice.fragments.AddPersonFragment;
import at.htlgkr.naughtyornice.fragments.ListOverviewFragment;
import at.htlgkr.naughtyornice.fragments.MenuFragment;
import at.htlgkr.naughtyornice.fragments.NoPersonFragment;
import at.htlgkr.naughtyornice.fragments.PersonOverviewFragment;
import at.htlgkr.naughtyornice.fragments.SettingsFragment;
import at.htlgkr.naughtyornice.viewmodel.LogicViewModel;
import at.htlgkr.naughtyornice.viewmodel.MainViewModel;

public class    MainActivity extends AppCompatActivity {

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
            if (state == MainViewModel.FIRST_PAGE){
                if (IOHandler.read(getApplicationContext()) == null){
                    transaction.add(R.id.main, new NoPersonFragment(), "NO PERSON FRAGMENT");
                    transaction.replace(R.id.main, new NoPersonFragment(), "NO PERSON FRAGMENT");
                }else {
                    transaction.add(R.id.main, new MenuFragment(), "MENU FRAGMENT");
                    transaction.replace(R.id.main, new MenuFragment(), "MENU FRAGMENT");
                }
            } else if (state == MainViewModel.ADD_PERSON) {
                transaction.replace(R.id.main, new AddPersonFragment(), "ADD PERSON FRAGMENT");
                transaction.addToBackStack("MENU FRAGMENT");
            }else if (state == MainViewModel.LIST_OVERVIEW){
                transaction.replace(R.id.main, new ListOverviewFragment(), "LIST OVERVIEW FRAGMENT");
                transaction.addToBackStack("MENU FRAGMENT");
            }else if (state == MainViewModel.SETTINGS){
                transaction.replace(R.id.main, new SettingsFragment(), "SETTINGS FRAGMENT");
            }else if (state == MainViewModel.PERSON_OVERVIEW){
                transaction.replace(R.id.main, new PersonOverviewFragment(), "PERSON OVERVIEW FRAGMENT");
                transaction.addToBackStack("PERSON OVERVIEW");
            }
            transaction.commit();
        });

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+43432423423"));
        startActivity(intent);
    }
}