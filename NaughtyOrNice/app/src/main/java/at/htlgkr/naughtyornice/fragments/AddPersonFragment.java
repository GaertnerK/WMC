package at.htlgkr.naughtyornice.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import at.htlgkr.naughtyornice.Person;
import at.htlgkr.naughtyornice.R;
import at.htlgkr.naughtyornice.databinding.FragmentAddPersonBinding;
import at.htlgkr.naughtyornice.viewmodel.LogicViewModel;
import at.htlgkr.naughtyornice.viewmodel.MainViewModel;

public class AddPersonFragment extends Fragment {

    private FragmentAddPersonBinding binding;

    public AddPersonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        LogicViewModel logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentAddPersonBinding.inflate(inflater, container, false);

        if (LogicViewModel.edit){
            binding.tfFirstname.getEditText().setText(logicViewModel.getPersonList().get(LogicViewModel.index).getFirstname().toString());
            binding.tfLastname.getEditText().setText(logicViewModel.getPersonList().get(LogicViewModel.index).getLastname().toString());
            binding.tfAge.getEditText().setText(logicViewModel.getPersonList().get(LogicViewModel.index).getAge().toString());
            binding.tfWish.getEditText().setText(logicViewModel.getPersonList().get(LogicViewModel.index).getWish().toString());
            if (logicViewModel.getPersonList().get(LogicViewModel.index).isBehavior()){
                binding.btBehavior.setText("Nice");
                binding.btBehavior.setBackgroundColor(Color.GREEN);
            }else {
                binding.btBehavior.setText("Naughty");
                binding.btBehavior.setBackgroundColor(Color.RED);
            }
        }else {
            binding.btBehavior.setBackgroundColor(Color.GREEN);
        }

        binding.btSave.setOnClickListener(view -> {
            boolean behavior = true;
            if (!binding.btBehavior.getText().toString().equals("Nice")){
                behavior = false;
            }
            if (binding.tfLastname.getEditText().getText().toString().isEmpty() || binding.tfFirstname.getEditText().getText().toString().isEmpty()
            || binding.tfAge.getEditText().getText().toString().isEmpty() || binding.tfWish.getEditText().getText().toString().isEmpty()){
                Snackbar.make(view, "Bitte alle Felder ausfüllen", BaseTransientBottomBar.LENGTH_SHORT).show();
            }else {
                logicViewModel.addPerson(new Person(binding.tfFirstname.getEditText().getText().toString(), binding.tfLastname.getEditText().getText().toString(), binding.tfAge.getEditText().getText().toString(), binding.tfWish.getEditText().getText().toString(), behavior));
                logicViewModel.safeList(getContext().getApplicationContext());
                mainViewModel.showListOverview();
            }
            LogicViewModel.edit = false;
        });

        binding.btBehavior.setOnClickListener(view -> {
            if (binding.btBehavior.getText().equals("Nice")) {
                binding.btBehavior.setText("Naughty");
                binding.btBehavior.setBackgroundColor(Color.RED);
            }else {
                binding.btBehavior.setText("Nice");
                binding.btBehavior.setBackgroundColor(Color.GREEN);
            }
        });

        return binding.getRoot();
    }
}