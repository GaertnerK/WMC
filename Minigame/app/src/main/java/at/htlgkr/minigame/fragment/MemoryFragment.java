package at.htlgkr.minigame.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import at.htlgkr.minigame.R;
import at.htlgkr.minigame.databinding.FragmentMemoryBinding;
import at.htlgkr.minigame.memory.Logic;

public class MemoryFragment extends Fragment {

    FragmentMemoryBinding binding;

    private ImageView[] imageViews;
    private Logic logic;
    private Map<Integer, Boolean> pictureIds;
    private int roundCounter;
    private TextView tv;
    private Button resetButton;
    private AtomicInteger tappedButton;

    public MemoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMemoryBinding.inflate(inflater, container, false);

        tappedButton = new AtomicInteger();

        pictureIds = new HashMap<>();
        pictureIds.put(R.drawable.ant, false);
        pictureIds.put(R.drawable.bird, false);
        pictureIds.put(R.drawable.cat, false);
        pictureIds.put(R.drawable.dog, false);
        pictureIds.put(R.drawable.hamster, false);
        pictureIds.put(R.drawable.mouse, false);
        pictureIds.put(R.drawable.rabbit, false);
        pictureIds.put(R.drawable.spider, false);

        Set<Integer> pictureIdsSet = pictureIds.keySet();

        List<Integer> pictureIdsList = new ArrayList<>();
        pictureIdsList.addAll(pictureIdsSet);

        tv = binding.roundCounter;

        resetButton = binding.resetBt;

        logic = new Logic(pictureIdsList);

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
                if (tappedButton.get() == 2){
                    addCounter();
                    for (ImageView iv : imageViews){
                        iv.setClickable(true);
                    }
                    logic.resetSwCard();
                    tappedButton.set(0);
                    switchCards();
                }
                if (view.getId() == binding.picture1.getId()){
                    imageView.setImageResource(logic.getId(0, 0));
                    if (logic.checkCard(logic.getId(0,0))) {
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(0, 0), true);
                    }
                }else if (view.getId() == binding.picture2.getId()) {
                    imageView.setImageResource(logic.getId(0, 1));
                    if (logic.checkCard(logic.getId(0,1))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(0, 1), true);
                    }
                }else if (view.getId() == binding.picture3.getId()) {
                    imageView.setImageResource(logic.getId(0, 2));
                    if (logic.checkCard(logic.getId(0,2))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(0, 2), true);
                    }
                }else if (view.getId() == binding.picture4.getId()) {
                    imageView.setImageResource(logic.getId(0, 3));
                    if (logic.checkCard(logic.getId(0,3))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(0, 3), true);
                    }
                }else if (view.getId() == binding.picture5.getId()) {
                    imageView.setImageResource(logic.getId(1, 0));
                    if (logic.checkCard(logic.getId(1,0))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(1,0), true);
                    }
                }else if (view.getId() == binding.picture6.getId()) {
                    imageView.setImageResource(logic.getId(1, 1));
                    if (logic.checkCard(logic.getId(1,1))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(1,1), true);
                    }
                }else if (view.getId() == binding.picture7.getId()) {
                    imageView.setImageResource(logic.getId(1, 2));
                    if (logic.checkCard(logic.getId(1,2))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(1, 2), true);
                    }
                }else if (view.getId() == binding.picture8.getId()) {
                    imageView.setImageResource(logic.getId(1, 3));
                    if (logic.checkCard(logic.getId(1,3))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(1,3), true);
                    }
                }else if (view.getId() == binding.picture9.getId()) {
                    imageView.setImageResource(logic.getId(2, 0));
                    if (logic.checkCard(logic.getId(2,0))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(2,0), true);
                    }
                }else if (view.getId() == binding.picture10.getId()) {
                    imageView.setImageResource(logic.getId(2, 1));
                    if (logic.checkCard(logic.getId(2,1))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(2,1), true);
                    }
                }else if (view.getId() == binding.picture11.getId()) {
                    imageView.setImageResource(logic.getId(2, 2));
                    if (logic.checkCard(logic.getId(2,2))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(2, 2), true);
                    }
                }else if (view.getId() == binding.picture12.getId()) {
                    imageView.setImageResource(logic.getId(2, 3));
                    if (logic.checkCard(logic.getId(2,3))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(2, 3), true);
                    }
                }else if (view.getId() == binding.picture13.getId()) {
                    imageView.setImageResource(logic.getId(3, 0));
                    if (logic.checkCard(logic.getId(3,0))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(3,0), true);
                    }
                }else if (view.getId() == binding.picture14.getId()) {
                    imageView.setImageResource(logic.getId(3, 1));
                    if (logic.checkCard(logic.getId(3,1))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(3,1), true);
                    }
                }else if (view.getId() == binding.picture15.getId()) {
                    imageView.setImageResource(logic.getId(3, 2));
                    if (logic.checkCard(logic.getId(3,2))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(3, 2), true);
                    }
                }else if (view.getId() == binding.picture16.getId()) {
                    imageView.setImageResource(logic.getId(3, 3));
                    if (logic.checkCard(logic.getId(3,3))){
                        Snackbar.make(view, "Richtig", BaseTransientBottomBar.LENGTH_SHORT).show();
                        pictureIds.replace(logic.getId(3,3), true);
                    }
                }
                imageView.setClickable(false);
                tappedButton.getAndIncrement();
            });
        }

        resetButton.setOnClickListener(view -> {
            for(int i : pictureIds.keySet()){
                pictureIds.replace(i, false);
            }

            for(ImageView temp : imageViews){
                temp.setImageResource(R.drawable.ic_launcher_background);
            }
            List<Integer> tempList = new ArrayList<>(pictureIds.keySet());
            logic = new Logic(pictureIdsList);
            logic.loadBoard();
            roundCounter = 0;
            tappedButton.set(0);

            for(ImageView iv : imageViews){
                iv.setClickable(true);
            }
        });

        return binding.getRoot();
    }

    public void switchCards(){
        int counter = 0;
        for (int i = 0; i < logic.getModel().getBoard().length; i++){
            for (int j = 0; j < logic.getModel().getBoard()[i].length; j++){
                if (!pictureIds.get(logic.getId(i, j))){
                    imageViews[counter].setImageResource(R.drawable.ic_launcher_background);
                }
                counter++;
            }
        }
    }

    public void addCounter(){
        roundCounter++;
        tv.setText(String.valueOf(roundCounter));
    }
}