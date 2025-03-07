package at.htlgkr.mychristmasapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.mychristmasapp.IOHandler;
import at.htlgkr.mychristmasapp.R;
import at.htlgkr.mychristmasapp.databinding.FragmentWreathBinding;
import at.htlgkr.mychristmasapp.viewmodel.LogicViewModel;
import at.htlgkr.mychristmasapp.viewmodel.MainViewModel;

public class WreathFragment extends Fragment {

    private FragmentWreathBinding binding;

    public WreathFragment() {
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
        binding = FragmentWreathBinding.inflate(inflater, container, false);

        if (IOHandler.read(getContext().getApplicationContext(), "candles.json") != null) {
            logicViewModel.readCandles(getContext().getApplicationContext());
            if (logicViewModel.getCandles()[0]) {
                binding.ivCandleOne.setImageResource(R.drawable.candle_big_lit);
            } else {
                binding.ivCandleOne.setImageResource(R.drawable.candle_big);
            }
            if (logicViewModel.getCandles()[1]) {
                binding.ivCandleTwo.setImageResource(R.drawable.candle_big_lit);
            } else {
                binding.ivCandleTwo.setImageResource(R.drawable.candle_big);
            }
            if (logicViewModel.getCandles()[2]) {
                binding.ivCandleThree.setImageResource(R.drawable.candle_big_lit);
            } else {
                binding.ivCandleThree.setImageResource(R.drawable.candle_big);
            }
            if (logicViewModel.getCandles()[3]) {
                binding.ivCandleFour.setImageResource(R.drawable.candle_big_lit);
            } else {
                binding.ivCandleFour.setImageResource(R.drawable.candle_big);
            }
        }

        binding.ivCandleOne.setOnClickListener(view -> {
            if (!logicViewModel.getCandles()[0]){
                binding.ivCandleOne.setImageResource(R.drawable.candle_big_lit);
                logicViewModel.getCandles()[0] = true;
            }else {
                binding.ivCandleOne.setImageResource(R.drawable.candle_big);
                logicViewModel.getCandles()[0] = false;
            }
            logicViewModel.safeCandles(getContext().getApplicationContext());
        });

        binding.ivCandleTwo.setOnClickListener(view -> {
            if (!logicViewModel.getCandles()[1]){
                binding.ivCandleTwo.setImageResource(R.drawable.candle_big_lit);
                logicViewModel.getCandles()[1] = true;
            }else {
                binding.ivCandleTwo.setImageResource(R.drawable.candle_big);
                logicViewModel.getCandles()[1] = false;
            }
            logicViewModel.safeCandles(getContext().getApplicationContext());
        });

        binding.ivCandleThree.setOnClickListener(view -> {
            if (!logicViewModel.getCandles()[2]){
                binding.ivCandleThree.setImageResource(R.drawable.candle_big_lit);
                logicViewModel.getCandles()[2] = true;
            }else {
                binding.ivCandleThree.setImageResource(R.drawable.candle_big);
                logicViewModel.getCandles()[2] = false;
            }
            logicViewModel.safeCandles(getContext().getApplicationContext());
        });

        binding.ivCandleFour.setOnClickListener(view -> {
            if (!logicViewModel.getCandles()[3]){
                binding.ivCandleFour.setImageResource(R.drawable.candle_big_lit);
                logicViewModel.getCandles()[3] = true;
            }else {
                binding.ivCandleFour.setImageResource(R.drawable.candle_big);
                logicViewModel.getCandles()[3] = false;
            }
            logicViewModel.safeCandles(getContext().getApplicationContext());
        });

        return binding.getRoot();
    }
}