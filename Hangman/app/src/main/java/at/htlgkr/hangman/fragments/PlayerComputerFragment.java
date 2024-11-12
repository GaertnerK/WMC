package at.htlgkr.hangman.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.hangman.Computer;
import at.htlgkr.hangman.R;
import at.htlgkr.hangman.databinding.FragmentPlayerComputerBinding;
import at.htlgkr.hangman.viewmodel.MainViewModel;

public class PlayerComputerFragment extends Fragment {

    FragmentPlayerComputerBinding binding;

    public PlayerComputerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        binding = FragmentPlayerComputerBinding.inflate(inflater, container, false);
        Computer computer = new Computer();

        binding.btEasy.setOnClickListener(view -> {
            viewModel.showGame();
            viewModel.setWord(computer.getRandomEasyWord());
            viewModel.setLogic();
        });
        binding.btHard.setOnClickListener(view -> {
            viewModel.showGame();
            viewModel.setWord(computer.getRandomHardWord());
            viewModel.setLogic();
        });
        return binding.getRoot();
    }
}