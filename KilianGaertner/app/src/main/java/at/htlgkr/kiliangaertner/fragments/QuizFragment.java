package at.htlgkr.kiliangaertner.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.htlgkr.kiliangaertner.R;
import at.htlgkr.kiliangaertner.databinding.FragmentProfilBinding;
import at.htlgkr.kiliangaertner.databinding.FragmentQuizBinding;
import at.htlgkr.kiliangaertner.viewmodel.LogicViewModel;
import at.htlgkr.kiliangaertner.viewmodel.MainViewModel;

public class QuizFragment extends Fragment {
    private LogicViewModel logicViewModel;
    private MainViewModel mainViewModel;
    private FragmentQuizBinding binding;
    private int points;

    public QuizFragment() {
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
        binding = FragmentQuizBinding.inflate(inflater, container, false);

        binding.tvQuestion.setText(logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getQuestion());
        binding.tvQuestionOne.setText(logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getAnswers()[0].getAnswer());
        binding.tvQuestionTwo.setText(logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getAnswers()[1].getAnswer());
        binding.tvQuestionThree.setText(logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getAnswers()[2].getAnswer());

        binding.cvQuestionOne.setOnClickListener(view -> {
            points = points + logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getAnswers()[0].getPoints();
            nextQuestions();
        });

        binding.cvQuestionTwo.setOnClickListener(view -> {
            points = points + logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getAnswers()[1].getPoints();
            nextQuestions();
        });

        binding.cvQuestionThree.setOnClickListener(view -> {
            points = points + logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getAnswers()[2].getPoints();
            nextQuestions();
        });

        return binding.getRoot();
    }

    public void nextQuestions(){
        logicViewModel.setQuestionIndex(logicViewModel.getQuestionIndex()+1);
        if (logicViewModel.getQuestionIndex() >= logicViewModel.getQuestions().length){
            logicViewModel.setQuizPoints(points);
            mainViewModel.showQuizEndScreen();
        }else {
            binding.tvQuestion.setText(logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getQuestion());
            binding.tvQuestionOne.setText(logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getAnswers()[0].getAnswer());
            binding.tvQuestionTwo.setText(logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getAnswers()[1].getAnswer());
            binding.tvQuestionThree.setText(logicViewModel.getQuestions()[logicViewModel.getQuestionIndex()].getAnswers()[2].getAnswer());
        }
    }
}