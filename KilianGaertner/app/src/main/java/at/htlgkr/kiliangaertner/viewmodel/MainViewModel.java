package at.htlgkr.kiliangaertner.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int OVERVIEW_SCREEN = 0;
    public static final int PROFILE_SCREEN = 1;
    public static final int COOKIE_SCREEN = 2;
    public static final int QUIZ_SCREEN = 3;
    public static final int QUIZ_END_SCREEN = 4;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(OVERVIEW_SCREEN);
    public LiveData<Integer> state = _state;

    public void showOverviewScreen(){
        _state.postValue(OVERVIEW_SCREEN);
    }

    public void showProfileScreen(){
        _state.postValue(PROFILE_SCREEN);
    }

    public void showCookieScreen(){
        _state.postValue(COOKIE_SCREEN);
    }

    public void showQuizScreen(){
        _state.postValue(QUIZ_SCREEN);
    }

    public void showQuizEndScreen(){
        _state.postValue(QUIZ_END_SCREEN);
    }
}
