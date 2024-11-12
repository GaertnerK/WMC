package at.htlgkr.digitalcookbook.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.digitalcookbook.R;
import at.htlgkr.digitalcookbook.databinding.FragmentRecipesIncludedBinding;
import at.htlgkr.digitalcookbook.viewmodel.MainViewModel;

public class RecipesIncludedFragment extends Fragment {

    FragmentRecipesIncludedBinding binding;

    public RecipesIncludedFragment() {
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
        binding = FragmentRecipesIncludedBinding.inflate(inflater, container, false);

        binding.btAddRecipe.setOnClickListener(view -> viewModel.showAddRecipe());
        binding.btRecipesOverview.setOnClickListener(view -> viewModel.showRecipesOverview());

        return binding.getRoot();
    }
}