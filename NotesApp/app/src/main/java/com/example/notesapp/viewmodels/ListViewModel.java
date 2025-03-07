package com.example.notesapp.viewmodels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.notesapp.model.Note;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    public MutableLiveData<List<Note>> observableNotes;
    private ArrayList<Note> notes;

    public ListViewModel() {
        this.observableNotes = new MutableLiveData<>();
        this.notes = new ArrayList<>();

        observableNotes.postValue(notes);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public void addNote(Note note){
        notes.add(note);
        observableNotes.postValue(notes);
    }

    public void deleteNote(Note note){
        notes.remove(note);
        observableNotes.postValue(notes);
    }
}
