package at.htlgkr.wmc1plfuebung.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.wmc1plfuebung.R;
import at.htlgkr.wmc1plfuebung.databinding.FragmentWelcomeBinding;
import at.htlgkr.wmc1plfuebung.viewmodels.LogicViewModel;
import at.htlgkr.wmc1plfuebung.viewmodels.MainViewModel;

public class WelcomeFragment extends Fragment {

    FragmentWelcomeBinding binding;

    public WelcomeFragment() {
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
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);

        binding.getRoot().setBackgroundResource(R.drawable.start_bg);
        binding.btNext.setBackgroundColor(Color.GREEN);
        binding.btNext.setOnClickListener(view -> {
            logicViewModel.setName(binding.tiName.getEditText().getText().toString());
            mainViewModel.showMainScreen();
        });

        return binding.getRoot();
    }
}