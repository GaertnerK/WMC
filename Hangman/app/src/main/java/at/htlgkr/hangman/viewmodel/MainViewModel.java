package at.htlgkr.hangman.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int MENU = 0;
    public static final int PLAYERVSPLAYER = 1;
    public static final int PLAYERVSCOMPUTER = 2;
    public static final int GAME = 3;

    private static String word = "";

    private MutableLiveData<Integer> _state = new MutableLiveData<>(MENU);
    public LiveData<Integer> state = _state;

    public void showPlayerVsPlayer(){
        _state.postValue(PLAYERVSPLAYER);
    }

    public void showPlayerVsComputer(){
        _state.postValue(PLAYERVSCOMPUTER);
    }

    public void showGame(){
        _state.postValue(GAME);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
