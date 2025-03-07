package at.htlgkr.digitalcookbook.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int firstPage = 0;
    public static final int addRecipe = 1;
    public static final int recipesOverview = 2;
    public static final int filterOverview = 3;
    public static final int recipeDetails = 4;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(firstPage);
    public LiveData<Integer> state = _state;

    public void showfirstPage(){
        _state.postValue(firstPage);
    }

    public void showAddRecipe(){
        _state.postValue(addRecipe);
    }

    public void showRecipesOverview(){
        _state.postValue(recipesOverview);
    }

    public void showFilterOverview(){
        _state.postValue(filterOverview);
    }

    public void showRecipeDetails(){
        _state.postValue(recipeDetails);
    }
}
