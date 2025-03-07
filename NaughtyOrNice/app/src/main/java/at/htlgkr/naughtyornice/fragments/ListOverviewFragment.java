package at.htlgkr.naughtyornice.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.naughtyornice.R;
import at.htlgkr.naughtyornice.databinding.FragmentListOverviewBinding;
import at.htlgkr.naughtyornice.viewmodel.LogicViewModel;
import at.htlgkr.naughtyornice.viewmodel.MainViewModel;


public class ListOverviewFragment extends Fragment {

    private FragmentListOverviewBinding binding;
    private int index = 0;

    public ListOverviewFragment() {
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
        binding = FragmentListOverviewBinding.inflate(inflater, container, false);

        binding.tvName.setText(logicViewModel.getPersonList().get(index).getFirstname() + " " + logicViewModel.getPersonList().get(index).getLastname());
        binding.tvItemIndex.setText((index+1) + "/" + logicViewModel.getPersonList().size());

        binding.btLeft.setOnClickListener(view -> {
            if ((index-1) < 0){
                index = logicViewModel.getPersonList().size()-1;
            }else {
                index--;
            }
            binding.tvName.setText(logicViewModel.getPersonList().get(index).getFirstname() + " " + logicViewModel.getPersonList().get(index).getLastname());
            binding.tvItemIndex.setText((index+1) + "/" + logicViewModel.getPersonList().size());
        });

        binding.btRight.setOnClickListener(view -> {
            if ((index+1) >= logicViewModel.getPersonList().size()){
                index = 0;
            }else {
                index++;
            }
            binding.tvName.setText(logicViewModel.getPersonList().get(index).getFirstname() + " " + logicViewModel.getPersonList().get(index).getLastname());
            binding.tvItemIndex.setText((index+1) + "/" + logicViewModel.getPersonList().size());
        });

        binding.btShowPerson.setOnClickListener(view -> {
            LogicViewModel.index = index;
            mainViewModel.showPersonOverview();
        });

        return binding.getRoot();
    }
}