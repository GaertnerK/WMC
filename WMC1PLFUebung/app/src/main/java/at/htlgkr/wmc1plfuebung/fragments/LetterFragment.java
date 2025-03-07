package at.htlgkr.wmc1plfuebung.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.wmc1plfuebung.IOHandler;
import at.htlgkr.wmc1plfuebung.R;
import at.htlgkr.wmc1plfuebung.databinding.FragmentLetterBinding;
import at.htlgkr.wmc1plfuebung.viewmodels.LogicViewModel;

public class LetterFragment extends Fragment {
    private FragmentLetterBinding binding;
    private LogicViewModel logicViewModel;

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
        logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentLetterBinding.inflate(inflater, container, false);

        if (IOHandler.read(getContext().getApplicationContext(), "letter.json") != null){
            logicViewModel.readLetter(getContext().getApplicationContext());
            binding.tiLetter.getEditText().setText(logicViewModel.getLetter());
        }

        binding.btSave.setOnClickListener(view -> {
            logicViewModel.setLetter(binding.tiLetter.getEditText().getText().toString());
            logicViewModel.safeLetter(getContext().getApplicationContext());
        });

        return binding.getRoot();
    }
}