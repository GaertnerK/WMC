package at.htlgkr.naughtyornice.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.Date;

import at.htlgkr.naughtyornice.R;
import at.htlgkr.naughtyornice.databinding.FragmentNoPersonBinding;
import at.htlgkr.naughtyornice.viewmodel.MainViewModel;

public class NoPersonFragment extends Fragment {
    private FragmentNoPersonBinding binding;

    public NoPersonFragment() {
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
        binding = FragmentNoPersonBinding.inflate(inflater, container, false);
        binding.btAddPerson.setOnClickListener(view -> {
            viewModel.showAddPerson();
        });

        binding.btSettings.setOnClickListener(view -> {
            viewModel.showSettings();
        });

        Date heute = new Date();
        Calendar weihnachten = Calendar.getInstance();
        weihnachten.set(Calendar.MONTH, Calendar.DECEMBER);
        weihnachten.set(Calendar.DAY_OF_MONTH, 25);
        if (heute.after(weihnachten.getTime())) {
            weihnachten.set(Calendar.YEAR, weihnachten.get(Calendar.YEAR) + 1);
        }
        long differenzInMillis = weihnachten.getTimeInMillis() - heute.getTime();
        long tageBisWeihnachten = differenzInMillis / (1000 * 60 * 60 * 24);
        binding.tvDays.setText(tageBisWeihnachten + "");
        return binding.getRoot();
    }
}