package at.htlgkr.naughtyornice.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.naughtyornice.R;
import at.htlgkr.naughtyornice.databinding.FragmentMenuBinding;
import at.htlgkr.naughtyornice.viewmodel.LogicViewModel;
import at.htlgkr.naughtyornice.viewmodel.MainViewModel;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        LogicViewModel logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentMenuBinding.inflate(inflater, container, false);

        logicViewModel.loadList(getContext().getApplicationContext());
        binding.tvListStatus.setText(logicViewModel.getPersonList().size() + " Person/en in der Liste.");
        binding.tvShowList.setOnClickListener(view -> {
            mainViewModel.showListOverview();
        });

        binding.btAddPerson.setOnClickListener(view -> {
            mainViewModel.showAddPerson();
        });

        binding.btSettings.setOnClickListener(view -> {
            mainViewModel.showSettings();
        });
        return binding.getRoot();
    }
}