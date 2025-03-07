package com.example.notesapp.viewmodels;

import androidx.lifecycle.ViewModel;

public class LogicViewModel extends ViewModel {
    private int clickedNote;

    public int getClickedNote() {
        return clickedNote;
    }

    public void setClickedNote(int clickedNote) {
        this.clickedNote = clickedNote;
    }
}
