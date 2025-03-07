package at.htlgkr.digitalcookbook.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.digitalcookbook.R;
import at.htlgkr.digitalcookbook.databinding.FragmentRecipeDetailsBinding;
import at.htlgkr.digitalcookbook.viewmodel.LogicViewModel;
import at.htlgkr.digitalcookbook.viewmodel.MainViewModel;

public class RecipeDetailsFragment extends Fragment {

    FragmentRecipeDetailsBinding binding;

    public RecipeDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        LogicViewModel logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);

        binding.tvNameTime.setText(logicViewModel.getRecipe(LogicViewModel.index).getName() + " (" + logicViewModel.getRecipe(LogicViewModel.index).getTime() + ")");
        binding.tvIngrediants.setText(binding.tvIngrediants.getText() + " " + logicViewModel.getRecipe(LogicViewModel.index).getIngrediants());
        binding.tvPreparation.setText(logicViewModel.getRecipe(LogicViewModel.index).getPreparaion());

        binding.btBack.setOnClickListener(view -> {
            viewModel.showRecipesOverview();
        });

        binding.btEdit.setOnClickListener(view -> {
            LogicViewModel.edit = true;
            viewModel.showAddRecipe();
        });
        return binding.getRoot();
    }
}