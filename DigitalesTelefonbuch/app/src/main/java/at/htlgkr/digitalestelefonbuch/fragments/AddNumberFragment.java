package at.htlgkr.digitalestelefonbuch.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import at.htlgkr.digitalestelefonbuch.Contact;
import at.htlgkr.digitalestelefonbuch.R;
import at.htlgkr.digitalestelefonbuch.databinding.FragmentAddNumberBinding;
import at.htlgkr.digitalestelefonbuch.viewmodels.LogicViewModel;
import at.htlgkr.digitalestelefonbuch.viewmodels.MainViewModel;

public class AddNumberFragment extends Fragment {
    FragmentAddNumberBinding binding;

    public AddNumberFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        LogicViewModel logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentAddNumberBinding.inflate(inflater, container, false);

        binding.btSave.setOnClickListener(view -> {
            if (binding.tfLastname.getEditText().getText().toString().isEmpty() || binding.tfFirstname.getEditText().getText().toString().isEmpty()
                    || binding.tfLastname.getEditText().getText().toString().isEmpty() || binding.tfNumber.getEditText().getText().toString().isEmpty()){
                Snackbar.make(view, "Bitte alle Felder ausfüllen", BaseTransientBottomBar.LENGTH_SHORT).show();
            }else {
                logicViewModel.addContact(new Contact(binding.tfFirstname.getEditText().getText().toString(), binding.tfLastname.getEditText().getText().toString(), binding.tfNumber.getEditText().getText().toString()));
                logicViewModel.safeList(getContext());
                viewModel.showNumbersOverview();
            }
        });

        return binding.getRoot();
    }
}