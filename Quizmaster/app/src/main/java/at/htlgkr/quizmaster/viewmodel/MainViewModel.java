package at.htlgkr.quizmaster.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int MENU = 0;
    public static final int QUIZ = 1;
    public static final int END = 2;

    private MutableLiveData<Integer>_state = new MutableLiveData<>(MENU);
    public LiveData<Integer> state = _state;

    public void showMenu(){
        _state.postValue(MENU);
    }

    public void showQuiz(){
        _state.postValue(QUIZ);
    }

    public void showEnd(){
        _state.postValue(END);
    }
}
