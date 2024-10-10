package at.htlgkr.minigame.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public static final int MENU = 0;
    public static final int MINI_GAME = 1;
    public static final int TIC_TAC_TOE = 2;
    public static final int MEMORY = 3;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(MENU);
    public LiveData<Integer> state = _state;

    public void showMiniGame(){
        _state.postValue(MINI_GAME);
    }

    public void showTicTacToe(){
        _state.postValue(TIC_TAC_TOE);
    }

    public void showMemory(){
        _state.postValue(MEMORY);
    }

}
