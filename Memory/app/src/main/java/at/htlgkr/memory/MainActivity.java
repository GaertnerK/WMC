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
    private ImageView[] imageViews;
    private Logic logic;
    private List<Integer> pictureIds;

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

        pictureIds = new ArrayList<>();
        pictureIds.add(R.drawable.ant);
        pictureIds.add(R.drawable.bird);
        pictureIds.add(R.drawable.cat);
        pictureIds.add(R.drawable.dog);
        pictureIds.add(R.drawable.hamster);
        pictureIds.add(R.drawable.mouse);
        pictureIds.add(R.drawable.rabbit);
        pictureIds.add(R.drawable.spider);


        logic = new Logic(pictureIds);
        logic.loadBoard();

        imageViews = new ImageView[16];

        imageViews[0] = (binding.picture1);
        imageViews[1] = (binding.picture2);
        imageViews[2] = (binding.picture3);
        imageViews[3] = (binding.picture4);
        imageViews[4] = (binding.picture5);
        imageViews[5] = (binding.picture6);
        imageViews[6] = (binding.picture7);
        imageViews[7] = (binding.picture8);
        imageViews[8] = (binding.picture9);
        imageViews[9] = (binding.picture10);
        imageViews[10] = (binding.picture11);
        imageViews[11] = (binding.picture12);
        imageViews[12] = (binding.picture13);
        imageViews[13] = (binding.picture14);
        imageViews[14] = (binding.picture15);
        imageViews[15] = (binding.picture16);

        for(ImageView view : imageViews){
            view.setImageResource(R.drawable.ic_launcher_background);
        }

        for(ImageView imageView : imageViews){
            imageView.setOnClickListener(view -> {
                if (view.getId() == R.id.picture1){
                    imageView.setImageResource(logic.getId(0, 0));
                }else if (view.getId() == R.id.picture2) {
                    imageView.setImageResource(logic.getId(0, 1));
                }else if (view.getId() == R.id.picture3) {
                    imageView.setImageResource(logic.getId(0, 2));
                }else if (view.getId() == R.id.picture4) {
                    imageView.setImageResource(logic.getId(0, 3));
                }else if (view.getId() == R.id.picture5) {
                    imageView.setImageResource(logic.getId(1, 0));
                }else if (view.getId() == R.id.picture6) {
                    imageView.setImageResource(logic.getId(1, 1));
                }else if (view.getId() == R.id.picture7) {
                    imageView.setImageResource(logic.getId(1, 2));
                }else if (view.getId() == R.id.picture8) {
                    imageView.setImageResource(logic.getId(1, 3));
                }else if (view.getId() == R.id.picture9) {
                    imageView.setImageResource(logic.getId(2, 0));
                }else if (view.getId() == R.id.picture10) {
                    imageView.setImageResource(logic.getId(2, 1));
                }else if (view.getId() == R.id.picture11) {
                    imageView.setImageResource(logic.getId(2, 2));
                }else if (view.getId() == R.id.picture12) {
                    imageView.setImageResource(logic.getId(2, 3));
                }else if (view.getId() == R.id.picture13) {
                    imageView.setImageResource(logic.getId(3, 0));
                }else if (view.getId() == R.id.picture14) {
                    imageView.setImageResource(logic.getId(3, 1));
                }else if (view.getId() == R.id.picture15) {
                    imageView.setImageResource(logic.getId(3, 2));
                }else if (view.getId() == R.id.picture16) {
                    imageView.setImageResource(logic.getId(3, 3));
                }
            });
        }
    }
}