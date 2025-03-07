package at.htlgkr.naughtyornice.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int FIRST_PAGE = 0;
    public static final int ADD_PERSON = 1;
    public static final int LIST_OVERVIEW = 2;
    public static final int SETTINGS = 3;
    public static final int PERSON_OVERVIEW = 4;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(FIRST_PAGE);
    public LiveData<Integer> state = _state;

    public void showFirstPage(){
        _state.postValue(FIRST_PAGE);
    }

    public void showAddPerson(){
        _state.postValue(ADD_PERSON);
    }

    public void showListOverview(){
        _state.postValue(LIST_OVERVIEW);
    }

    public void showSettings(){
        _state.postValue(SETTINGS);
    }

    public void showPersonOverview(){
        _state.postValue(PERSON_OVERVIEW);
    }
}
