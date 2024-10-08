package at.htlgkr.gaert;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import at.htlgkr.gaert.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private Button[] btLeft;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void registerForContextMenu(@NonNull View view) {
        super.registerForContextMenu(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);

        btLeft =

        return binding.getRoot();
    }
}