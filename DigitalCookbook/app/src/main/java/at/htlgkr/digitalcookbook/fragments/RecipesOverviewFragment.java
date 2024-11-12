package at.htlgkr.digitalcookbook.fragments;

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

        logicViewModel.loadRecipes(getContext().getApplicationContext());
        binding.tvName.setText(logicViewModel.getRecipe(index).getName());
        binding.tvIngredients.setText(logicViewModel.getRecipe(index).getIngrediants());
        binding.tvRecipeCounter.setText(index+1 + "/" + logicViewModel.getRecipes().size()+1);


        return binding.getRoot();
    }
}