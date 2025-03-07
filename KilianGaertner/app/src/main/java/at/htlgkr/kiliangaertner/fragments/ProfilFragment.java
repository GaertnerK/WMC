package at.htlgkr.kiliangaertner.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import at.htlgkr.kiliangaertner.IOHandler;
import at.htlgkr.kiliangaertner.R;
import at.htlgkr.kiliangaertner.databinding.FragmentProfilBinding;
import at.htlgkr.kiliangaertner.viewmodel.LogicViewModel;
import at.htlgkr.kiliangaertner.viewmodel.MainViewModel;

public class ProfilFragment extends Fragment {
    private FragmentProfilBinding binding;
    private LogicViewModel logicViewModel;
    private MainViewModel mainViewModel;

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        binding = FragmentProfilBinding.inflate(inflater, container, false);

        if (IOHandler.read(getContext().getApplicationContext(), "profile.json") != null){
            logicViewModel.readProfile(getContext().getApplicationContext());
            binding.tiName.getEditText().setText(logicViewModel.getProfil().getName());
            binding.tiAge.getEditText().setText(logicViewModel.getProfil().getAge());
        }

        binding.btSave.setOnClickListener(view -> {
            if (!binding.tiName.getEditText().getText().toString().isEmpty()
                    && !binding.tiAge.getEditText().getText().toString().isEmpty()) {
                logicViewModel.getProfil().setName(binding.tiName.getEditText().getText().toString());
                logicViewModel.getProfil().setAge(binding.tiAge.getEditText().getText().toString());
                logicViewModel.safeProfile(getContext().getApplicationContext());
                mainViewModel.showOverviewScreen();
            }else {
                Snackbar.make(view, "Felder nicht leer lassen!", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}