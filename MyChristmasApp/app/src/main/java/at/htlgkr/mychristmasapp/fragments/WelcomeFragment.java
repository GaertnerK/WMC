package at.htlgkr.mychristmasapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.mychristmasapp.R;
import at.htlgkr.mychristmasapp.databinding.FragmentWelcomeBinding;
import at.htlgkr.mychristmasapp.viewmodel.LogicViewModel;
import at.htlgkr.mychristmasapp.viewmodel.MainViewModel;

public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;

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

        binding.btNext.setOnClickListener(view -> {
            logicViewModel.setName(binding.tfName.getEditText().getText().toString());
            mainViewModel.showMainScreen();
        });

        return binding.getRoot();
    }
}