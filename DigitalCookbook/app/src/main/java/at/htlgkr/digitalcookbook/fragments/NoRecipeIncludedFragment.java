package at.htlgkr.digitalcookbook.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.digitalcookbook.R;
import at.htlgkr.digitalcookbook.databinding.FragmentNoRecipeIncludedBinding;
import at.htlgkr.digitalcookbook.viewmodel.MainViewModel;

public class NoRecipeIncludedFragment extends Fragment {

    FragmentNoRecipeIncludedBinding binding;

    public NoRecipeIncludedFragment() {
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
        binding = FragmentNoRecipeIncludedBinding.inflate(inflater, container, false);

        binding.btNewRecipe.setOnClickListener(view -> viewModel.showAddRecipe());
        return binding.getRoot();
    }
}