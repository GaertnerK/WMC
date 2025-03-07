package at.htlgkr.naughtyornice.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.naughtyornice.R;
import at.htlgkr.naughtyornice.databinding.FragmentEinstellungenBinding;
import at.htlgkr.naughtyornice.viewmodel.LogicViewModel;
import at.htlgkr.naughtyornice.viewmodel.MainViewModel;

public class SettingsFragment extends Fragment {

    FragmentEinstellungenBinding binding;

    public SettingsFragment() {
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
        binding = FragmentEinstellungenBinding.inflate(inflater, container, false);

        if (LogicViewModel.filter == 0) {
            binding.btFilter.setText("Alles anzeigen");
        }else if (LogicViewModel.filter == 1){
            binding.btFilter.setText("Nur Nice anzeigen");
        }else {
            binding.btFilter.setText("Nur Naughty anzeigen");
        }

        binding.btBack.setOnClickListener(view -> {
            mainViewModel.showFirstPage();
        });

        binding.btFilter.setOnClickListener(view -> {
            if (LogicViewModel.filter+1 > 2){
                LogicViewModel.filter = 0;
            }else {
                LogicViewModel.filter++;
            }
            if (LogicViewModel.filter == 0){
                binding.btFilter.setText("Alle anzeigen");
            } else if (LogicViewModel.filter == 1) {
                binding.btFilter.setText("Nur Nice anzeigen");
            }else{
                binding.btFilter.setText("Nur Naughty anzeigen");
            }
        });

        return binding.getRoot();
    }
}