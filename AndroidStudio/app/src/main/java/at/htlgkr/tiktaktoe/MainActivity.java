package at.htlgkr.tiktaktoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;

    private Logic logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        b1 = findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.button5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.button6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.button7);
        b7.setOnClickListener(this);
        b8 = findViewById(R.id.button8);
        b8.setOnClickListener(this);
        b9 = findViewById(R.id.button9);
        b9.setOnClickListener(this);

        logic = new Logic();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1){
            b1.setText(logic.setButton(1));
        }else if (view.getId() == R.id.button2){
            b2.setText(logic.setButton(2));
        }else if (view.getId() == R.id.button3){
            b3.setText(logic.setButton(3));
        }else if (view.getId() == R.id.button4){
            b4.setText(logic.setButton(4));
        }else if (view.getId() == R.id.button5){
            b5.setText(logic.setButton(5));
        }else if (view.getId() == R.id.button6){
            b6.setText(logic.setButton(6));
        }else if (view.getId() == R.id.button7){
            b7.setText(logic.setButton(7));
        }else if (view.getId() == R.id.button8){
            b8.setText(logic.setButton(8));
        }else if (view.getId() == R.id.button9){
            b9.setText(logic.setButton(9));
        }
    }
}