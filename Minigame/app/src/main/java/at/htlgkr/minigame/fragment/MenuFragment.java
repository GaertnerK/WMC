package at.htlgkr.minigame.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.minigame.MainActivity;
import at.htlgkr.minigame.R;
import at.htlgkr.minigame.databinding.FragmentMenuBinding;
import at.htlgkr.minigame.viewmodel.MainViewModel;

public class MenuFragment extends Fragment {

    FragmentMenuBinding binding;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding = FragmentMenuBinding.inflate(inflater, container, false);

        binding.btMiniGame.setOnClickListener(view -> viewModel.showMiniGame());
        binding.btTTT.setOnClickListener(view -> viewModel.showTicTacToe());
        binding.btMemory.setOnClickListener(view -> viewModel.showMemory());
        return binding.getRoot();
    }
}