package at.htlgkr.minigame;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

import at.htlgkr.minigame.databinding.ActivityMainBinding;
import at.htlgkr.minigame.databinding.FragmentMiniGameBinding;

public class MiniGameFragment extends Fragment {

    private FragmentMiniGameBinding binding;
    private TextInputEditText editText;

    public MiniGameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMiniGameBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}