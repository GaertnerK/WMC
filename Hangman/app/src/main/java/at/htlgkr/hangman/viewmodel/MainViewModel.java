package at.htlgkr.hangman.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import at.htlgkr.hangman.gamelogic.Logic;

public class MainViewModel extends ViewModel {
    public static final int MENU = 0;
    public static final int PLAYERVSPLAYER = 1;
    public static final int PLAYERVSCOMPUTER = 2;
    public static final int GAME = 3;
    public static final int NEWGAME = 4;

    private static String message = "";
    private static String word = "";
    private Logic logic;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(MENU);
    public LiveData<Integer> state = _state;

    public void setLogic() {
        logic = new Logic(word);
    }

    public void showMenu(){
        _state.postValue(MENU);
    }

    public void showPlayerVsPlayer(){
        _state.postValue(PLAYERVSPLAYER);
    }

    public void showPlayerVsComputer(){
        _state.postValue(PLAYERVSCOMPUTER);
    }

    public void showGame(){
        _state.postValue(GAME);
    }

    public void showNewGame(){
        _state.postValue(NEWGAME);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String checkLetter(String letter){
        return logic.checkLetter(letter);
    }
}
