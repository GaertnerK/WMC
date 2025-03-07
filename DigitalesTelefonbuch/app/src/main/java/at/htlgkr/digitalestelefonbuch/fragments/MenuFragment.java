package at.htlgkr.digitalestelefonbuch.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.digitalestelefonbuch.R;
import at.htlgkr.digitalestelefonbuch.databinding.FragmentMenuBinding;
import at.htlgkr.digitalestelefonbuch.viewmodels.LogicViewModel;
import at.htlgkr.digitalestelefonbuch.viewmodels.MainViewModel;

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
        LogicViewModel logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentMenuBinding.inflate(inflater, container, false);

        binding.llContacts.setOnClickListener(view -> {
            logicViewModel.favourites = false;
            viewModel.showNumbersOverview();
        });

        binding.llFavourites.setOnClickListener(view -> {
            logicViewModel.favourites = true;
            viewModel.showNumbersOverview();
        });

        binding.btAdd.setOnClickListener(view -> viewModel.showAddNumber());

        return binding.getRoot();
    }
}