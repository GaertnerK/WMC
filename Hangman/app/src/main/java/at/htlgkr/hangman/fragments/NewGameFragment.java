package at.htlgkr.hangman.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.hangman.R;
import at.htlgkr.hangman.databinding.FragmentNewGameBinding;
import at.htlgkr.hangman.viewmodel.MainViewModel;

public class NewGameFragment extends Fragment {

    FragmentNewGameBinding binding;

    public NewGameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewGameBinding.inflate(inflater, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.tvMessage.setText(viewModel.getMessage());
        binding.btNewGame.setOnClickListener(view -> viewModel.showMenu());

        return binding.getRoot();
    }
}