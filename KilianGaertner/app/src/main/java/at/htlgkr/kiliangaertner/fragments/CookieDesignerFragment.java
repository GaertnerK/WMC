package at.htlgkr.kiliangaertner.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import at.htlgkr.kiliangaertner.IOHandler;
import at.htlgkr.kiliangaertner.R;
import at.htlgkr.kiliangaertner.databinding.FragmentCookieDesignerBinding;
import at.htlgkr.kiliangaertner.viewmodel.LogicViewModel;

public class CookieDesignerFragment extends Fragment {
    private FragmentCookieDesignerBinding binding;
    private LogicViewModel logicViewModel;


    public CookieDesignerFragment() {
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
        binding = FragmentCookieDesignerBinding.inflate(inflater, container, false);

        List<Integer> cookiesIds = new ArrayList<>();
        cookiesIds.add(R.drawable.cookie_decorated1);
        cookiesIds.add(R.drawable.cookie_decorated2);
        cookiesIds.add(R.drawable.cookie_decorated3);
        cookiesIds.add(R.drawable.cookie_undecorated);

        if (!IOHandler.read(getContext().getApplicationContext(), "cookie.json").isEmpty()){
            logicViewModel.readCookie(getContext().getApplicationContext());
            for (int i = 0; i < cookiesIds.size(); i++){
                if (cookiesIds.get(i) == logicViewModel.getCookie()){
                    binding.ivCookies.setImageResource(cookiesIds.get(i));
                }
            }
        }else {
            binding.ivCookies.setImageResource(cookiesIds.get(0));
        }


        binding.ivLeft.setOnClickListener(view -> {
            if (logicViewModel.getCookieIndex()-1 < 0){
                logicViewModel.setCookieIndex(cookiesIds.size()-1);
            }else {
                logicViewModel.setCookieIndex(logicViewModel.getCookieIndex()-1);
            }
            binding.ivCookies.setImageResource(cookiesIds.get(logicViewModel.getCookieIndex()));
            logicViewModel.setCookie(cookiesIds.get(logicViewModel.getCookieIndex()));
            logicViewModel.safeCookie(getContext().getApplicationContext());
        });

        binding.ivRight.setOnClickListener(view -> {
            if (logicViewModel.getCookieIndex()+1 >= cookiesIds.size()){
                logicViewModel.setCookieIndex(0);
            }else {
                logicViewModel.setCookieIndex(logicViewModel.getCookieIndex()+1);
            }
            binding.ivCookies.setImageResource(cookiesIds.get(logicViewModel.getCookieIndex()));
            logicViewModel.setCookie(cookiesIds.get(logicViewModel.getCookieIndex()));
            logicViewModel.safeCookie(getContext().getApplicationContext());
        });

        return binding.getRoot();
    }
}