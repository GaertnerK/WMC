package at.htlgkr.digitalestelefonbuch.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModel extends ViewModel {
    public static final int FIRST_PAGE = 0;
    public static final int ADD_NUMBER = 1;
    public static final int NUMBERS_OVERVIEW = 2;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(FIRST_PAGE);
    public LiveData<Integer> state = _state;

    public void showFirstPage(){
        _state.postValue(FIRST_PAGE);
    }
    public void showAddNumber(){
        _state.postValue(ADD_NUMBER);
    }
    public void showNumbersOverview(){
        _state.postValue(NUMBERS_OVERVIEW);
    }
}
