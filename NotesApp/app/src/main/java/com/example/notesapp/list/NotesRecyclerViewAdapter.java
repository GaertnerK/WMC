package com.example.notesapp.list;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.notesapp.callback.NoteOnClickListener;
import com.example.notesapp.databinding.FragmentNotesListBinding;
import com.example.notesapp.model.Note;

import java.util.List;

public class NotesRecyclerViewAdapter extends RecyclerView.Adapter<NotesRecyclerViewAdapter.ViewHolder> {

    private final List<Note> mValues;
    private NoteOnClickListener noteClickListener;

    public NotesRecyclerViewAdapter(List<Note> items) {
        mValues = items;
    }

    public void setOnClickListener(NoteOnClickListener noteClickListener){
        this.noteClickListener = noteClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentNotesListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitle.setText(mValues.get(position).getTitle());
        holder.tvDesc.setText(mValues.get(position).getDescription());
        holder.tvDate.setText(mValues.get(position).getDate().toString());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvTitle;
        public final TextView tvDesc;
        public final TextView tvDate;
        public Note mItem;

        public ViewHolder(FragmentNotesListBinding binding) {
            super(binding.getRoot());
            tvTitle = binding.tvTitle;
            tvDesc = binding.tvDescription;
            tvDate = binding.tvDate;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvDesc.getText() + "'";
        }
    }
}