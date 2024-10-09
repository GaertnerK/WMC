package at.htlgkr.minigame;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import at.htlgkr.minigame.databinding.FragmentMiniGameBinding;

public class MiniGameFragment extends Fragment {

    private FragmentMiniGameBinding binding;
    private String[] tfInput;
    private Logic logic;
    private TextInputEditText[] editTexts;
    private ImageView[] imageViews;

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

    @SuppressLint("SetTextI18n")
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

        imageViews = new ImageView[5];
        imageViews[0] = binding.imageView;
        imageViews[1] = binding.imageView2;
        imageViews[2] = binding.imageView3;
        imageViews[3] = binding.imageView4;
        imageViews[4] = binding.imageView5;

        tfInput = new String[5];

        binding.btCheck.setOnClickListener(view -> {
            for (int i = 0; i < editTexts.length; i++){
                tfInput[i] = editTexts[i].getText().toString();
            }


            String[] tempArr = tfInput.clone();

            if (logic.checkWin(tfInput)){
                Snackbar.make(container, "Richtig, bitte neues Wort erraten!", BaseTransientBottomBar.LENGTH_SHORT).show();
                for (ImageView imageView : imageViews){
                    imageView.setImageResource(R.drawable.white2);
                }
                for (TextInputEditText editText : editTexts){
                    editText.setHint("");
                }
                logic.setWord();
                for (TextInputEditText temp : editTexts) {
                    temp.setText("");
                }
            } else {
                int counter = 0;
                for(String letter : logic.checkWord(tfInput)){
                    if (letter.equalsIgnoreCase("1")){
                        imageViews[counter].setImageResource(R.drawable.yellow);
                        editTexts[counter].setHint(editTexts[counter].getText());
                        editTexts[counter].setText("");

                    }else if(letter.equalsIgnoreCase("")){
                        editTexts[counter].setText(letter);
                        binding.tvWrong.setText(binding.tvWrong.getText() + " " + tempArr[counter]);
                        imageViews[counter].setImageResource(R.drawable.red);
                        editTexts[counter].setHint("");

                    } else {
                        imageViews[counter].setImageResource(R.drawable.green);
                    }
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