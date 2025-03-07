package at.htlgkr.kiliangaertner.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.kiliangaertner.R;
import at.htlgkr.kiliangaertner.databinding.FragmentOverviewBinding;
import at.htlgkr.kiliangaertner.viewmodel.LogicViewModel;
import at.htlgkr.kiliangaertner.viewmodel.MainViewModel;

public class OverviewFragment extends Fragment {

    private FragmentOverviewBinding binding;
    private MainViewModel mainViewModel;
    private LogicViewModel logicViewModel;

    public OverviewFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentOverviewBinding.inflate(inflater, container, false);

        if (logicViewModel.isQuizFinished()){
            binding.cvQuiz.setVisibility(View.INVISIBLE);
        }

        binding.cvQuiz.setOnClickListener(view -> mainViewModel.showQuizScreen());
        binding.cvDesigner.setOnClickListener(view -> mainViewModel.showCookieScreen());
        binding.cvProfile.setOnClickListener(view -> mainViewModel.showProfileScreen());
        binding.ivCookie.setImageResource(R.drawable.cookie_decorated1);

        return binding.getRoot();
    }
}