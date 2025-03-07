package com.example.notesapp.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notesapp.R;
import com.example.notesapp.databinding.FragmentNotesListListBinding;
import com.example.notesapp.viewmodels.ListViewModel;
import com.example.notesapp.viewmodels.LogicViewModel;
import com.example.notesapp.viewmodels.MainViewModel;

public class NotesListFragment extends Fragment {

    private MainViewModel mainViewModel;
    private ListViewModel listViewModel;
    private LogicViewModel logicViewModel;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotesListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotesListFragment newInstance(int columnCount) {
        NotesListFragment fragment = new NotesListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        View view = inflater.inflate(R.layout.fragment_notes_list_list, container, false);
        View listView = view.findViewById(R.id.list);

        // Set the adapter
        if (listView instanceof RecyclerView) {
            Context context = listView.getContext();
            RecyclerView recyclerView = (RecyclerView) listView;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            listViewModel.observableNotes.observe(getViewLifecycleOwner(), notes -> {
                NotesRecyclerViewAdapter adapter = new NotesRecyclerViewAdapter(notes);
                recyclerView.setAdapter(adapter);
                adapter.setOnClickListener(position -> {
                    mainViewModel.showEditNotes();
                });
            });

            view.findViewById(R.id.ivAdd).setOnClickListener(v -> {
                mainViewModel.showAddNotes();
            });

        }
        return view;
    }
}