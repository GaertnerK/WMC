package com.example.notesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava3.RxDataStore;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.notesapp.fragments.AddNoteFragment;
import com.example.notesapp.fragments.EditNoteFragment;
import com.example.notesapp.fragments.SettingsFragment;
import com.example.notesapp.list.NotesListFragment;
import com.example.notesapp.viewmodels.MainViewModel;
import com.google.android.material.datepicker.MaterialDatePicker;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

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
            if (state == MainViewModel.NOTES_LIST){
                transaction.add(R.id.main, new NotesListFragment(), "NOTE LIST");
                transaction.replace(R.id.main, new NotesListFragment(), "NOTE LIST");
            }else if (state == MainViewModel.ADD_NOTES){
                transaction.replace(R.id.main, new AddNoteFragment());
            }else if (state == MainViewModel.EDIT_NOTES){
                transaction.replace(R.id.main, new EditNoteFragment());
            }else if (state == MainViewModel.SETTINGS){
                transaction.replace(R.id.main, new SettingsFragment());
            }
            transaction.commit();
        });

        /*SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("ID", 4);
        editor.apply();

        int highScore = sharedPref.getInt("ID", 0);
        Log.i("highscore", highScore + "");





        RxDataStore<Preferences> dataStore =
                new RxPreferenceDataStoreBuilder(getApplicationContext(), /*name=*/ /*"settings").build();

        Preferences.Key<Integer> EXAMPLE_COUNTER = PreferencesKeys.intKey("ID");

        Flowable<Integer> exampleCounterFlow =
                dataStore.data().map(prefs -> prefs.get(EXAMPLE_COUNTER));

        try {
            Log.i("PREFS", exampleCounterFlow.first(0).blockingGet() + "");
        }catch (Exception e){
            Log.i("PREFS", "no value present");
        }

        Single<Preferences> updateResult =  dataStore.updateDataAsync(prefsIn -> {
            MutablePreferences mutablePreferences = prefsIn.toMutablePreferences();
            Integer currentInt = prefsIn.get(EXAMPLE_COUNTER);
            mutablePreferences.set(EXAMPLE_COUNTER, currentInt != null ? currentInt + 1 : 1);
            return Single.just(mutablePreferences);
        });

        Integer test = updateResult.blockingGet().get(EXAMPLE_COUNTER);
        Log.i("PREFS", test + "");

        Log.i("PREFS", exampleCounterFlow.first(0).blockingGet() + "");

        */
    }
}