package at.htlgkr.wmc1plfuebung.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import at.htlgkr.wmc1plfuebung.IOHandler;
import at.htlgkr.wmc1plfuebung.R;
import at.htlgkr.wmc1plfuebung.databinding.FragmentWishesBinding;
import at.htlgkr.wmc1plfuebung.databinding.FragmentWreathBinding;
import at.htlgkr.wmc1plfuebung.viewmodels.LogicViewModel;

public class WreathFragment extends Fragment {
    private FragmentWreathBinding binding;
    private LogicViewModel logicViewModel;

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
        logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentWreathBinding.inflate(inflater, container, false);

        if (IOHandler.read(getContext().getApplicationContext(), "candles.json") != null){
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
            setCandle(binding.ivCandleOne, 0);
            logicViewModel.safeCandles(getContext().getApplicationContext());
        });

        binding.ivCandleTwo.setOnClickListener(view -> {
            setCandle(binding.ivCandleTwo, 1);
            logicViewModel.safeCandles(getContext().getApplicationContext());
        });

        binding.ivCandleThree.setOnClickListener(view -> {
            setCandle(binding.ivCandleThree, 2);
            logicViewModel.safeCandles(getContext().getApplicationContext());
        });

        binding.ivCandleFour.setOnClickListener(view -> {
            setCandle(binding.ivCandleFour, 3);
            logicViewModel.safeCandles(getContext().getApplicationContext());
        });

        return binding.getRoot();
    }

    public void setCandle(ImageView view, int i){
        if (logicViewModel.getCandles()[i]) {
            view.setImageResource(R.drawable.candle_big);
            logicViewModel.getCandles()[i] = false;
        }else {
            view.setImageResource(R.drawable.candle_big_lit);
            logicViewModel.getCandles()[i] = true;
        }
    }
}