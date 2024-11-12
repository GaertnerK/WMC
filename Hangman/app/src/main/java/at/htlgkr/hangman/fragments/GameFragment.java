package at.htlgkr.hangman.fragments;

import android.inputmethodservice.AbstractInputMethodService;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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

        for (int i = 0; i < viewModel.getWord().length(); i++){
            binding.tvWord.setText(binding.tvWord.getText() + "_ ");
            Log.i("Word", viewModel.getWord());
        }

        int[] picturesIds = new int[9];
        picturesIds[0] = R.drawable.p1;
        picturesIds[1] = R.drawable.p2;
        picturesIds[2] = R.drawable.p3;
        picturesIds[3] = R.drawable.p4;
        picturesIds[4] = R.drawable.p5;
        picturesIds[5] = R.drawable.p6;
        picturesIds[6] = R.drawable.p7;
        picturesIds[7] = R.drawable.p8;
        picturesIds[8] = R.drawable.p9;

        AtomicInteger failCounter = new AtomicInteger();

        binding.btCheck.setOnClickListener(view -> {
            if (binding.teLetter.getText() == null){
                Snackbar.make(view, "Buchstaben eingeben!!!", BaseTransientBottomBar.LENGTH_SHORT).show();
            }else {
                String s = viewModel.checkLetter(binding.teLetter.getText().toString());
                String temp = " ";
                binding.tvWord.setText("");
                for (int i = 0; i < s.length(); i++){
                    if (s.charAt(i) == temp.charAt(0)){
                        binding.tvWord.setText(binding.tvWord.getText() + "_ ");
                        if (!binding.tvWrongLetters.getText().toString().contains(binding.teLetter.getText().toString()) && !s.toLowerCase().contains(binding.teLetter.getText().toString())) {
                            binding.tvWrongLetters.setText(binding.tvWrongLetters.getText().toString() + " " + binding.teLetter.getText().toString());
                        }
                    }else {
                        binding.tvWord.setText(binding.tvWord.getText() + String.valueOf(s.charAt(i)) + " ");
                    }
                }
                if (failCounter.get() == picturesIds.length-2){
                    viewModel.setMessage("Sie hatten keine Versuche mehr!");
                    viewModel.showNewGame();
                }
                if (!s.toLowerCase().contains(binding.teLetter.getText().toString())){
                    failCounter.getAndIncrement();
                    binding.ivPicture.setImageResource(picturesIds[failCounter.get()]);
                }
            }
            binding.teLetter.setText("");
            String s = binding.tvWord.getText().toString().replaceAll(" ", "");
            String s2 = viewModel.getWord();
            if (s2.equals(s)){
                viewModel.setMessage("Gratulation! Sie haben gewonnen!");
                viewModel.showNewGame();
            }
        });

        binding.ivPicture.setImageResource(R.drawable.p0);

        return binding.getRoot();
    }
}