package at.htlgkr.memory;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import at.htlgkr.memory.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding  binding;
    private List<ImageView> imageViews;
    private Logic logic;
    private int[] pictureIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pictureIds = new int[8];
        pictureIds[0] = R.drawable.ant;
        pictureIds[1] = R.drawable.bird;
        pictureIds[2] = R.drawable.cat;
        pictureIds[3] = R.drawable.dog;
        pictureIds[4] = R.drawable.hamster;
        pictureIds[5] = R.drawable.mouse;
        pictureIds[6] = R.drawable.rabbit;
        pictureIds[7] = R.drawable.spider;


        logic = new Logic(pictureIds);
        logic.loadBoard();

        imageViews = new ArrayList<>();

        imageViews.add(binding.picture1);
        imageViews.add(binding.picture2);
        imageViews.add(binding.picture3);
        imageViews.add(binding.picture4);
        imageViews.add(binding.picture5);
        imageViews.add(binding.picture6);
        imageViews.add(binding.picture7);
        imageViews.add(binding.picture8);
        imageViews.add(binding.picture9);
        imageViews.add(binding.picture10);
        imageViews.add(binding.picture11);
        imageViews.add(binding.picture12);
        imageViews.add(binding.picture13);
        imageViews.add(binding.picture14);
        imageViews.add(binding.picture15);
        imageViews.add(binding.picture16);

        for(ImageView view : imageViews){
            view.setImageResource(R.drawable.ic_launcher_background);
        }

        for(ImageView imageView : imageViews){
            imageView.setOnClickListener(view -> {

            });
        }
    }
}