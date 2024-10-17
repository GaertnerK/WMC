package at.htlgkr.hangman.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import at.htlgkr.hangman.R;
import at.htlgkr.hangman.databinding.FragmentGameBinding;
import at.htlgkr.hangman.gamelogic.Logic;
import at.htlgkr.hangman.viewmodel.MainViewModel;

public class GameFragment extends Fragment {

    private FragmentGameBinding binding;
    private Logic logic;

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
        logic = new Logic(viewModel.getWord());

        for (int i = 0; i < viewModel.getWord().length(); i++){
            binding.tvWord.setText(binding.tvWord.getText() + "_ ");
        }

        binding.btCheck.setOnClickListener(view -> {
            if (binding.teLetter.getText().equals("")){
                Snackbar.make(view, "Buchstaben eingeben!!!", BaseTransientBottomBar.LENGTH_SHORT).show();
            }else {
                String s = logic.checkLetter(binding.teLetter.getText().toString());
                for (int i = 0; i < s.length(); i++){
                    if (s.charAt(i) ==  )
                }
            }
        });

        binding.ivPicture.setImageResource(R.drawable.p0);

        return binding.getRoot();
    }
}