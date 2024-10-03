package at.htlgkr.minigame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import at.htlgkr.minigame.databinding.FragmentMiniGameBinding;

public class MiniGameFragment extends Fragment {

    private FragmentMiniGameBinding binding;
    private String[] tfInput;
    private Logic logic;
    private TextInputEditText[] editTexts;

    @Override
    public void registerForContextMenu(@NonNull View view) {
        super.registerForContextMenu(view);
    }

    public MiniGameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMiniGameBinding.inflate(inflater, container, false);

        logic = new Logic();
        logic.setWord();

        editTexts = new TextInputEditText[5];
        editTexts[0] = binding.etOne;
        editTexts[1] = binding.etTwo;
        editTexts[2] = binding.etThree;
        editTexts[3] = binding.etFour;
        editTexts[4] = binding.etFive;

        tfInput = new String[5];

        binding.btCheck.setOnClickListener(view -> {
            for (int i = 0; i < editTexts.length; i++){
                tfInput[i] = editTexts[i].getText().toString();
            }

            if (logic.checkWin(tfInput)){
                Snackbar.make(container, "Richtig, neues Wort bitte erraten!", BaseTransientBottomBar.LENGTH_SHORT).show();
                logic.setWord();
                for (TextInputEditText temp : editTexts) {
                    temp.setText("");
                }
            } else {
                int counter = 0;
                for(String letter : logic.checkWord(tfInput)){
                    editTexts[counter].setText(letter);
                    counter++;
                }
            }
        });

        binding.btReveal.setOnClickListener(view -> {
            int counter = 0;
            for(String letter : logic.getWord().getLetters()){
                editTexts[counter].setText(letter);
                counter++;
            }
        });

        return binding.getRoot();
    }
}