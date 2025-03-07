package com.example.notesapp.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.notesapp.R;
import com.example.notesapp.databinding.FragmentAddNoteBinding;
import com.example.notesapp.model.Note;
import com.example.notesapp.viewmodels.ListViewModel;
import com.example.notesapp.viewmodels.MainViewModel;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class AddNoteFragment extends Fragment {

    private FragmentAddNoteBinding binding;
    private ListViewModel listViewModel;
    private MainViewModel mainViewModel;

    private Date date;

    public AddNoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false);
        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.ivCalendar.setOnClickListener(v -> {
            MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Select date").build();
            datePicker.addOnPositiveButtonClickListener(selection -> {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(selection);
                date = calendar.getTime();
                Toast.makeText(getContext().getApplicationContext(), "selection: " + date.toString(), Toast.LENGTH_SHORT).show();
            });
            datePicker.show(getParentFragmentManager(), "DATE PICKER");
        });

        binding.btAdd.setOnClickListener(v -> {
            listViewModel.addNote(new Note(
                    binding.tiTitle.getEditText().getText().toString(),
                    binding.tiDesc.getEditText().getText().toString(),
                    date
            ));
            mainViewModel.showNotesList();
        });

        return binding.getRoot();
    }
}