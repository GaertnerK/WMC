package at.htlgkr.kiliangaertner.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.kiliangaertner.R;
import at.htlgkr.kiliangaertner.databinding.FragmentQuizBinding;
import at.htlgkr.kiliangaertner.databinding.FragmentQuizEndBinding;
import at.htlgkr.kiliangaertner.viewmodel.LogicViewModel;
import at.htlgkr.kiliangaertner.viewmodel.MainViewModel;

public class QuizEndFragment extends Fragment {
    private FragmentQuizEndBinding binding;
    private LogicViewModel logicViewModel;
    private MainViewModel mainViewModel;

    public QuizEndFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentQuizEndBinding.inflate(inflater, container, false);

        binding.tvPoints.setText(logicViewModel.getQuizPoints() + "/9");
        if (logicViewModel.getQuizPoints() <= 3){
            binding.tvWords.setText("Du bist scheinbar noch nicht so richtig in Weihnachtsstimmung. Zünd’ dir eine\n" +
                    " Kerze an und genieße die schönste Zeit im Jahr.");
        }else if(logicViewModel.getQuizPoints() <= 6){
            binding.tvWords.setText("Lass die Weihnachtsmagie auf dich wirken und dreh’ dir dein liebstes\n" +
                    " Weihnachtslied auf. ");
        }else {
            binding.tvWords.setText("Kann Weihnachten überhaupt ohne dich stattfinden? Du lebst Weihnachten.");
        }

        binding.btEnd.setOnClickListener(view -> {
            logicViewModel.setQuizFinished(true);
            mainViewModel.showOverviewScreen();
        });

        return binding.getRoot();
    }
}