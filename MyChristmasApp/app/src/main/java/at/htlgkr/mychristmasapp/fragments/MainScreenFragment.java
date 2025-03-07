package at.htlgkr.mychristmasapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.mychristmasapp.R;
import at.htlgkr.mychristmasapp.databinding.FragmentMainScreen2Binding;
import at.htlgkr.mychristmasapp.viewmodel.LogicViewModel;
import at.htlgkr.mychristmasapp.viewmodel.MainViewModel;

public class MainScreenFragment extends Fragment {

    private FragmentMainScreen2Binding binding;

    public MainScreenFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        LogicViewModel logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentMainScreen2Binding.inflate(inflater, container, false);

        binding.cvWreath.setOnClickListener(view -> mainViewModel.showWreathScreen());
        binding.cvWishes.setOnClickListener(view -> mainViewModel.showWishesScreen());
        binding.cvLetter.setOnClickListener(view -> mainViewModel.showLetterScreen());

        binding.tvName.setText(logicViewModel.getName());

        return binding.getRoot();
    }
}