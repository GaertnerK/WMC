package at.htlgkr.quizmaster.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import at.htlgkr.quizmaster.R;
import at.htlgkr.quizmaster.databinding.FragmentQuizBinding;
import at.htlgkr.quizmaster.viewmodel.MainViewModel;
import at.htlgkr.quizmaster.viewmodel.QuizViewModel;

public class QuizFragment extends Fragment {

    FragmentQuizBinding binding;
    int hintCounter;

    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QuizViewModel quizViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        binding = FragmentQuizBinding.inflate(inflater, container, false);

        hintCounter = 0;

        binding.tvHint.setText((hintCounter + 1) + ". Hinweis: \n" + quizViewModel.getSolution().getHints()[hintCounter]);

        binding.btNextHint.setOnClickListener(view -> {
            if (hintCounter == 1){
                binding.btNextHint.setText("Aufgeben");
            }
            hintCounter++;
            if (hintCounter >= quizViewModel.getSolution().getHints().length){
                quizViewModel.message = "Falsch! Sie haben es nicht geschafft!";
                viewModel.showEnd();
            }else {
                binding.tvHint.setText((hintCounter + 1) + ". Hinweis: \n" + quizViewModel.getSolution().getHints()[hintCounter]);
            }
        });

        binding.btCheck.setOnClickListener(view -> {
            if (binding.teGuess.getText().toString().equals(quizViewModel.getSolution().getTitle())){
                quizViewModel.message = "Richtig! Sie haben " + (hintCounter+1) + " Versuche gebraucht";
                viewModel.showEnd();
            }else {
                Snackbar.make(view, "Falsch", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
        return binding.getRoot();
    }
}