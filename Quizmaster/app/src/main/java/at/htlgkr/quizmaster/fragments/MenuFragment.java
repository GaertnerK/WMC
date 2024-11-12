package at.htlgkr.quizmaster.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

import at.htlgkr.quizmaster.MainActivity;
import at.htlgkr.quizmaster.R;
import at.htlgkr.quizmaster.databinding.FragmentMenuBinding;
import at.htlgkr.quizmaster.viewmodel.MainViewModel;
import at.htlgkr.quizmaster.viewmodel.QuizViewModel;

public class MenuFragment extends Fragment {

    FragmentMenuBinding binding;
    List<Button> buttons;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        QuizViewModel quizViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);
        binding = FragmentMenuBinding.inflate(inflater, container, false);

        buttons = new ArrayList<>();
        buttons.add(binding.btMovies);
        buttons.add(binding.btCars);

        try {
            quizViewModel.readFile("items.csv", getContext().getApplicationContext());
        } catch (IOException e) {
            Log.e("Runtime Exception", "onCreateView: ", e);
        }

        buttons.forEach(value -> value.setOnClickListener(view -> {
            quizViewModel.setSolution(value.getText().toString());
            mainViewModel.showQuiz();
        }));

        return binding.getRoot();
    }
}