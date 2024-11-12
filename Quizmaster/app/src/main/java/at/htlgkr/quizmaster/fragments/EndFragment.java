package at.htlgkr.quizmaster.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.security.Provider;

import at.htlgkr.quizmaster.R;
import at.htlgkr.quizmaster.databinding.FragmentEndBinding;
import at.htlgkr.quizmaster.viewmodel.MainViewModel;
import at.htlgkr.quizmaster.viewmodel.QuizViewModel;

public class EndFragment extends Fragment {

    FragmentEndBinding binding;

    public EndFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEndBinding.inflate(inflater, container, false);
        QuizViewModel quizViewModel = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.tvMessage.setText(quizViewModel.message);
        binding.tvDescription.setText("Richtig: " + quizViewModel.getSolution().getTitle());
        binding.btCategory.setOnClickListener(view -> mainViewModel.showMenu());
        return binding.getRoot();
    }
}