package at.htlgkr.hangman.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.hangman.R;
import at.htlgkr.hangman.databinding.FragmentPlayerPlayerBinding;
import at.htlgkr.hangman.viewmodel.MainViewModel;

public class PlayerPlayerFragment extends Fragment {

    FragmentPlayerPlayerBinding binding;

    public PlayerPlayerFragment() {
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
        binding = FragmentPlayerPlayerBinding.inflate(inflater, container, false);

        binding.btContiune.setOnClickListener(view -> {
            viewModel.showGame();
            viewModel.setWord(binding.teWord.getText().toString());
            Log.i("Word", viewModel.getWord());
            viewModel.setLogic();
        });
        return binding.getRoot();
    }
}