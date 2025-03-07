package at.htlgkr.mychristmasapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int WELCOME_SCREEN = 0;
    public static final int MAIN_SCREEN = 1;
    public static final int WREATH_SCREEN = 2;
    public static final int WISHES_SCREEN = 3;
    public static final int LETTER_SCREEN = 4;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(WELCOME_SCREEN);
    public LiveData<Integer> state = _state;

    public void showWelcomeScreen(){
        _state.postValue(WELCOME_SCREEN);
    }

    public void showMainScreen(){
        _state.postValue(MAIN_SCREEN);
    }
    public void showWreathScreen(){
        _state.postValue(WREATH_SCREEN);
    }

    public void showWishesScreen(){
        _state.postValue(WISHES_SCREEN);
    }

    public void showLetterScreen(){
        _state.postValue(LETTER_SCREEN);
    }
}
