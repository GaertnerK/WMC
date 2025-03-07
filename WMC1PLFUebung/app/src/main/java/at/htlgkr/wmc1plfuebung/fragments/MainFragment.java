package at.htlgkr.wmc1plfuebung.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.wmc1plfuebung.R;
import at.htlgkr.wmc1plfuebung.databinding.FragmentMainBinding;
import at.htlgkr.wmc1plfuebung.viewmodels.LogicViewModel;
import at.htlgkr.wmc1plfuebung.viewmodels.MainViewModel;

public class MainFragment extends Fragment {
    private FragmentMainBinding binding;

    public MainFragment() {
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
        binding = FragmentMainBinding.inflate(inflater, container, false);


        binding.tvName.setText(logicViewModel.getName());
        binding.cvWishes.setOnClickListener(view -> mainViewModel.showWishesScreen());
        binding.cvWreath.setOnClickListener(view -> mainViewModel.showWreathScreen());
        binding.cvLetter.setOnClickListener(view -> mainViewModel.showLetterScreen());

        return binding.getRoot();
    }
}