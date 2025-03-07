package at.htlgkr.digitalcookbook.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.stream.Collectors;

import at.htlgkr.digitalcookbook.R;
import at.htlgkr.digitalcookbook.databinding.FragmentFilterBinding;
import at.htlgkr.digitalcookbook.viewmodel.LogicViewModel;
import at.htlgkr.digitalcookbook.viewmodel.MainViewModel;

public class FilterFragment extends Fragment {
    FragmentFilterBinding binding;

    public FilterFragment() {
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
        binding = FragmentFilterBinding.inflate(inflater, container, false);

        binding.btSetFilter.setOnClickListener(view -> {
            logicViewModel.loadRecipes(getContext().getApplicationContext());
            logicViewModel.filterdRecipes = logicViewModel.getRecipes().stream()
                    .filter(r -> r.getName().contains(binding.teFilter.getText()) || r.getIngrediants().contains(binding.teFilter.getText()) || r.getPreparaion().contains(binding.teFilter.getText()))
                    .collect(Collectors.toList());
            logicViewModel.loadFilteredRecipes();
            if (!logicViewModel.filterdRecipes.isEmpty()) {
                viewModel.showRecipesOverview();
                LogicViewModel.filter = true;
            }
        });

        binding.btResetFilter.setOnClickListener(view -> {
            logicViewModel.loadRecipes(getContext().getApplicationContext());
            viewModel.showRecipesOverview();
            LogicViewModel.filter = false;
        });

        return binding.getRoot();
    }
}