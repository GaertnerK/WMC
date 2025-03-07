package at.htlgkr.wmc1plfuebung.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.stream.Collectors;

import at.htlgkr.wmc1plfuebung.IOHandler;
import at.htlgkr.wmc1plfuebung.R;
import at.htlgkr.wmc1plfuebung.databinding.FragmentWishesBinding;
import at.htlgkr.wmc1plfuebung.viewmodels.LogicViewModel;
import at.htlgkr.wmc1plfuebung.viewmodels.MainViewModel;

public class WishesFragment extends Fragment {
    private FragmentWishesBinding binding;

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

        if (IOHandler.read(getContext().getApplicationContext(), "wishes.json") != null){
            binding.llAddWishes.setVisibility(View.INVISIBLE);
            logicViewModel.readWishes(getContext().getApplicationContext());
            binding.tvWishOne.setText(logicViewModel.getWishes().get(0));
            binding.tvWishTwo.setText(logicViewModel.getWishes().get(1));
            binding.tvWishThree.setText(logicViewModel.getWishes().get(2));
        }else {
            binding.ivPen.setVisibility(View.INVISIBLE);
            binding.llWishes.setVisibility(View.INVISIBLE);
        }

        binding.btSaveWishes.setOnClickListener(view -> {
            binding.ivPen.setVisibility(View.VISIBLE);
            binding.llWishes.setVisibility(View.VISIBLE);
            binding.llAddWishes.setVisibility(View.INVISIBLE);

            String[] parts = binding.tiWishes.getEditText().getText().toString().split(", ");
            binding.tvWishOne.setText(parts[0]);
            binding.tvWishTwo.setText(parts[1]);
            binding.tvWishThree.setText(parts[2]);
            logicViewModel.setWishes(Arrays.stream(parts).collect(Collectors.toList()));
            logicViewModel.safeWishes(getContext().getApplicationContext());
        });

        binding.ivPen.setOnClickListener(view -> {
            binding.llAddWishes.setVisibility(View.VISIBLE);
            binding.ivPen.setVisibility(View.INVISIBLE);
        });

        return binding.getRoot();
    }
}