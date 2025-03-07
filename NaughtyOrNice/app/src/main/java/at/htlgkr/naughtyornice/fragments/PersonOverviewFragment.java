package at.htlgkr.naughtyornice.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.naughtyornice.R;
import at.htlgkr.naughtyornice.databinding.FragmentPersonOverviewBinding;
import at.htlgkr.naughtyornice.viewmodel.LogicViewModel;
import at.htlgkr.naughtyornice.viewmodel.MainViewModel;

public class PersonOverviewFragment extends Fragment {

    private FragmentPersonOverviewBinding binding;

    public PersonOverviewFragment() {
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
        binding = FragmentPersonOverviewBinding.inflate(inflater, container, false);

        if (logicViewModel.getPersonList().get(LogicViewModel.index).isBehavior()) {
            binding.getRoot().setBackgroundColor(Color.GREEN);
        }else {
            binding.getRoot().setBackgroundColor(Color.RED);
        }

        binding.tvName.setText(logicViewModel.getPersonList().get(LogicViewModel.index).getFirstname() + " " + logicViewModel.getPersonList().get(LogicViewModel.index).getLastname());
        binding.tvAge.setText(logicViewModel.getPersonList().get(LogicViewModel.index).getAge() + " Jahre");
        binding.tvWish.setText("Wünscht sich: " + logicViewModel.getPersonList().get(LogicViewModel.index).getWish());

        binding.btBack.setOnClickListener(view -> mainViewModel.showListOverview());

        binding.ivEdit.setOnClickListener(view -> {
            LogicViewModel.edit = true;
            mainViewModel.showAddPerson();
        });

        return binding.getRoot();
    }
}