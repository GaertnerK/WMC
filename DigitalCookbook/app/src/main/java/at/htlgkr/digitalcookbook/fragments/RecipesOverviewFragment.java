package at.htlgkr.digitalcookbook.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.digitalcookbook.R;
import at.htlgkr.digitalcookbook.databinding.FragmentRecipesOverviewBinding;
import at.htlgkr.digitalcookbook.viewmodel.LogicViewModel;
import at.htlgkr.digitalcookbook.viewmodel.MainViewModel;

public class RecipesOverviewFragment extends Fragment {

    FragmentRecipesOverviewBinding binding;

    private int index = 0;

    public RecipesOverviewFragment() {
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
        binding = FragmentRecipesOverviewBinding.inflate(inflater, container, false);

        if (!LogicViewModel.filter) {
            logicViewModel.loadRecipes(getContext().getApplicationContext());
        }

        binding.tvName.setText(logicViewModel.getRecipe(index).getName());
        binding.tvIngredients.setText(logicViewModel.getRecipe(index).getIngrediants());
        binding.tvRecipeCounter.setText((index+1) + "/" + (logicViewModel.getRecipes().size()));

        binding.btLeft.setOnClickListener(view -> {
            if (index - 1 < 0){
                index = logicViewModel.getRecipes().size()-1;
            }else {
                index -= 1;
            }
            binding.tvName.setText(logicViewModel.getRecipe(index).getName());
            binding.tvIngredients.setText(logicViewModel.getRecipe(index).getIngrediants());
            binding.tvRecipeCounter.setText((index+1) + "/" + (logicViewModel.getRecipes().size()));
        });

        binding.btRight.setOnClickListener(view -> {
            if (index + 1 >= logicViewModel.getRecipes().size()){
                index = 0;
            }else {
                index += 1;
            }
            binding.tvName.setText(logicViewModel.getRecipe(index).getName());
            binding.tvIngredients.setText(logicViewModel.getRecipe(index).getIngrediants());
            binding.tvRecipeCounter.setText((index+1) + "/" + (logicViewModel.getRecipes().size()));
        });

        binding.btFilter.setOnClickListener(view -> {
            viewModel.showFilterOverview();
        });

        binding.btClearRecipes.setOnClickListener(view -> {
            logicViewModel.clearRecipes();
            logicViewModel.safeRecipes(getContext().getApplicationContext());
            viewModel.showfirstPage();
        });

        binding.btShowRecipe.setOnClickListener(view -> {
            LogicViewModel.index = index;
            viewModel.showRecipeDetails();
        });

        binding.btHome.setOnClickListener(view -> {
            viewModel.showfirstPage();
        });
        return binding.getRoot();
    }
}