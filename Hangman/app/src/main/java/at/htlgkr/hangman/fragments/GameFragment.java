package at.htlgkr.hangman.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.hangman.R;
import at.htlgkr.hangman.databinding.FragmentGameBinding;
import at.htlgkr.hangman.viewmodel.MainViewModel;

public class GameFragment extends Fragment {

    private FragmentGameBinding binding;

    public GameFragment() {
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

        binding = FragmentGameBinding.inflate(inflater, container, false);

        binding.ivPicture.setImageResource(R.drawable.p0);

        return binding.getRoot();
    }
}