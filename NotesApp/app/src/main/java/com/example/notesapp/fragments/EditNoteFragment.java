package com.example.notesapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notesapp.R;
import com.example.notesapp.databinding.FragmentEditNoteBinding;
import com.example.notesapp.model.Note;
import com.example.notesapp.viewmodels.ListViewModel;
import com.example.notesapp.viewmodels.LogicViewModel;
import com.example.notesapp.viewmodels.MainViewModel;

public class EditNoteFragment extends Fragment {
    private FragmentEditNoteBinding binding;
    private MainViewModel mainViewModel;
    private LogicViewModel logicViewModel;
    private ListViewModel listViewModel;
    private Note note;

    public EditNoteFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEditNoteBinding.inflate(inflater, container, false);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);

        note = listViewModel.getNotes().get(logicViewModel.getClickedNote());

        binding.tvNoteTitle.setText(note.getTitle());
        binding.tvDeadline.setText(note.getDate().toString());
        binding.tvNoteDescription.setText(note.getDescription());
        return binding.getRoot();
    }
}