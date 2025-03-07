package at.htlgkr.mychristmasapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.mychristmasapp.IOHandler;
import at.htlgkr.mychristmasapp.R;
import at.htlgkr.mychristmasapp.databinding.FragmentLetterBinding;
import at.htlgkr.mychristmasapp.viewmodel.LogicViewModel;

public class LetterFragment extends Fragment {

    private FragmentLetterBinding binding;

    public LetterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LogicViewModel logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentLetterBinding.inflate(inflater, container, false);

        if (IOHandler.read(getContext().getApplicationContext(), "letter.json") != null){
            logicViewModel.readLetter(getContext().getApplicationContext());
            binding.tfLetter.getEditText().setText(logicViewModel.getLetter());
        }

        binding.btSaveLetter.setOnClickListener(view -> {
            logicViewModel.setLetter(binding.tfLetter.getEditText().getText().toString());
            logicViewModel.safeLetter(getContext().getApplicationContext());
        });

        return binding.getRoot();
    }
}