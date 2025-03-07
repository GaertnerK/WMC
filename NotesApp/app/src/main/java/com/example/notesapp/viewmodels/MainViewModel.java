package com.example.notesapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public static final int NOTES_LIST = 0;
    public static final int ADD_NOTES = 1;
    public static final int EDIT_NOTES = 2;
    public static final int SETTINGS = 3;

    private MutableLiveData<Integer> _state = new MutableLiveData<>(NOTES_LIST);
    public LiveData<Integer> state = _state;

    public void showNotesList(){
        _state.postValue(NOTES_LIST);
    }
    public void showAddNotes(){
        _state.postValue(ADD_NOTES);
    }
    public void showEditNotes(){
        _state.postValue(EDIT_NOTES);
    }
    public void showSettings(){
        _state.postValue(SETTINGS);
    }
}
