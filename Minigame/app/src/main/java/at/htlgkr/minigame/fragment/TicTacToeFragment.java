package at.htlgkr.minigame.fragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import at.htlgkr.minigame.R;
import at.htlgkr.minigame.databinding.FragmentMenuBinding;
import at.htlgkr.minigame.databinding.FragmentTicTacToeBinding;
import at.htlgkr.minigame.tictactoe.Logic;

public class TicTacToeFragment extends Fragment implements View.OnClickListener {

    FragmentTicTacToeBinding binding;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    TextView winMessage;
    Button bt_reset;

    private Logic logic;

    public TicTacToeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTicTacToeBinding.inflate(inflater, container, false);

        b1 = binding.button1;
        b1.setOnClickListener(this);
        b2 = binding.button2;
        b2.setOnClickListener(this);
        b3 = binding.button3;
        b3.setOnClickListener(this);
        b4 = binding.button4;
        b4.setOnClickListener(this);
        b5 = binding.button5;
        b5.setOnClickListener(this);
        b6 = binding.button6;
        b6.setOnClickListener(this);
        b7 = binding.button7;
        b7.setOnClickListener(this);
        b8 = binding.button8;
        b8.setOnClickListener(this);
        b9 = binding.button9;
        b9.setOnClickListener(this);

        bt_reset = binding.btReset;
        bt_reset.setOnClickListener(this);

        winMessage = binding.tvWinMessage;

        logic = new Logic();
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1){
            b1.setText(logic.setButton(1, b1.getText().toString()));
            if (logic.win()){
                winMessage.setText("Player " + b1.getText() + " won!");
            }
        }else if (view.getId() == R.id.button2){
            b2.setText(logic.setButton(2, b2.getText().toString()));
            if (logic.win()){
                winMessage.setText("Player " + b2.getText() + " won!");
            }
        }else if (view.getId() == R.id.button3){
            b3.setText(logic.setButton(3, b3.getText().toString()));
            if (logic.win()){
                winMessage.setText("Player " + b3.getText() + " won!");
            }
        }else if (view.getId() == R.id.button4){
            b4.setText(logic.setButton(4, b4.getText().toString()));
            if (logic.win()){
                winMessage.setText("Player " + b4.getText() + " won!");
            }
        }else if (view.getId() == R.id.button5){
            b5.setText(logic.setButton(5, b5.getText().toString()));
            if (logic.win()){
                winMessage.setText("Player " + b5.getText() + " won!");
            }
        }else if (view.getId() == R.id.button6){
            b6.setText(logic.setButton(6, b6.getText().toString()));
            if (logic.win()){
                winMessage.setText("Player " + b6.getText() + " won!");
            }
        }else if (view.getId() == R.id.button7){
            b7.setText(logic.setButton(7, b7.getText().toString()));
            if (logic.win()){
                winMessage.setText("Player " + b7.getText() + " won!");
            }
        }else if (view.getId() == R.id.button8){
            b8.setText(logic.setButton(8, b8.getText().toString()));
            if (logic.win()){
                winMessage.setText("Player " + b8.getText() + " won!");
            }
        }else if (view.getId() == R.id.button9){
            b9.setText(logic.setButton(9, b9.getText().toString()));
            if (logic.win()){
                winMessage.setText("Player " + b9.getText() + " won!");
            }
        }
        if (logic.win()) {
            b1.setClickable(false);
            b2.setClickable(false);
            b3.setClickable(false);
            b4.setClickable(false);
            b5.setClickable(false);
            b6.setClickable(false);
            b7.setClickable(false);
            b8.setClickable(false);
            b9.setClickable(false);
        }

        if (view.getId() == R.id.bt_reset){
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
            b1.setClickable(true);
            b2.setClickable(true);
            b3.setClickable(true);
            b4.setClickable(true);
            b5.setClickable(true);
            b6.setClickable(true);
            b7.setClickable(true);
            b8.setClickable(true);
            b9.setClickable(true);
            winMessage.setText("");
            logic = new Logic();
        }
    }
}