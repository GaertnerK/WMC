package at.htlgkr.digitalestelefonbuch.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.digitalestelefonbuch.R;
import at.htlgkr.digitalestelefonbuch.databinding.FragmentNoNumberBinding;
import at.htlgkr.digitalestelefonbuch.viewmodels.MainViewModel;

public class NoNumberFragment extends Fragment {
    FragmentNoNumberBinding binding;

    public NoNumberFragment() {
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
        binding = FragmentNoNumberBinding.inflate(inflater, container, false);

        binding.btAddNumber.setOnClickListener(view -> {
            viewModel.showAddNumber();
        });

        return binding.getRoot();
    }
}