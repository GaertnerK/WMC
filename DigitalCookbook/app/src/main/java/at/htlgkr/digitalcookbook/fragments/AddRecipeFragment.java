package at.htlgkr.digitalcookbook.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.security.Provider;

import at.htlgkr.digitalcookbook.R;
import at.htlgkr.digitalcookbook.Recipe;
import at.htlgkr.digitalcookbook.databinding.FragmentAddRecipeBinding;
import at.htlgkr.digitalcookbook.viewmodel.LogicViewModel;
import at.htlgkr.digitalcookbook.viewmodel.MainViewModel;

public class AddRecipeFragment extends Fragment {

    FragmentAddRecipeBinding binding;

    public AddRecipeFragment() {
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
        binding = FragmentAddRecipeBinding.inflate(inflater, container, false);

        binding.btSave.setOnClickListener(view -> {
            logicViewModel.addRecipe(new Recipe(binding.tfName.getEditText().getText().toString(), binding.tfIngredients.getEditText().getText().toString(), binding.tfPreparation.getEditText().getText().toString(), Integer.parseInt(binding.tfTime.getEditText().getText().toString())));
            logicViewModel.safeRecipes(getContext().getApplicationContext());
            viewModel.showRecipesOverview();
        });

        return binding.getRoot();
    }
}