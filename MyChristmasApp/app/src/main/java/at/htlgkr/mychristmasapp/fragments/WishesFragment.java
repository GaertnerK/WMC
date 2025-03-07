package at.htlgkr.mychristmasapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import at.htlgkr.mychristmasapp.IOHandler;
import at.htlgkr.mychristmasapp.R;
import at.htlgkr.mychristmasapp.databinding.FragmentWishesBinding;
import at.htlgkr.mychristmasapp.viewmodel.LogicViewModel;
import at.htlgkr.mychristmasapp.viewmodel.MainViewModel;

public class WishesFragment extends Fragment {

    FragmentWishesBinding binding;

    public WishesFragment() {
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
        binding = FragmentWishesBinding.inflate(inflater, container, false);
        if (IOHandler.read(getContext().getApplicationContext(), "wishes.json") == null){
            binding.llWishes.setVisibility(View.INVISIBLE);
            binding.ivPen.setVisibility(View.INVISIBLE);
        }else {
            binding.llAddWish.setVisibility(View.INVISIBLE);
            logicViewModel.readWishes(getContext().getApplicationContext());
            binding.tvWishOne.setText("1. " + logicViewModel.getWishes().get(0));
            binding.tvWishTwo.setText("2. " + logicViewModel.getWishes().get(1));
            binding.tvWishThree.setText("3. " + logicViewModel.getWishes().get(2));
        }

        binding.btSave.setOnClickListener(view -> {
            String s = binding.tfWishes.getEditText().getText().toString();
            String[] parts = s.split(", ");
            if (parts.length != 3){
                Snackbar.make(view, "Die 3 Wünsche mit einem Beistrich trennen!!!", BaseTransientBottomBar.LENGTH_SHORT).show();
            }else {
                logicViewModel.setWishes(Arrays.stream(parts).collect(Collectors.toList()));
            }

            binding.llAddWish.setVisibility(View.INVISIBLE);
            binding.llWishes.setVisibility(View.VISIBLE);
            binding.ivPen.setVisibility(View.VISIBLE);
            binding.tvWishOne.setText("1. " + logicViewModel.getWishes().get(0));
            binding.tvWishTwo.setText("2. " + logicViewModel.getWishes().get(1));
            binding.tvWishThree.setText("3. " + logicViewModel.getWishes().get(2));
            logicViewModel.safeWishes(getContext().getApplicationContext());
        });

        binding.ivPen.setOnClickListener(view -> {
            binding.ivPen.setVisibility(View.INVISIBLE);
            binding.llAddWish.setVisibility(View.VISIBLE);
            binding.tfWishes.getEditText().setText("");
        });

        return binding.getRoot();
    }
}