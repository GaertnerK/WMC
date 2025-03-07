package at.htlgkr.digitalestelefonbuch.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.stream.Collectors;

import at.htlgkr.digitalestelefonbuch.Contact;
import at.htlgkr.digitalestelefonbuch.R;
import at.htlgkr.digitalestelefonbuch.databinding.FragmentListOverviewBinding;
import at.htlgkr.digitalestelefonbuch.viewmodels.LogicViewModel;
import at.htlgkr.digitalestelefonbuch.viewmodels.MainViewModel;

public class ListOverviewFragment extends Fragment {
    FragmentListOverviewBinding binding;

    public ListOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        LogicViewModel logicViewModel = new ViewModelProvider(requireActivity()).get(LogicViewModel.class);
        binding = FragmentListOverviewBinding.inflate(inflater, container, false);

        logicViewModel.readList(getContext().getApplicationContext());

        logicViewModel.index = 0;

        if (!logicViewModel.favourites) {
            setContact(logicViewModel);
        }else {
            setFavourtie(logicViewModel);
        }

        binding.btLeft.setOnClickListener(view -> {
            if (!logicViewModel.favourites) {
                if (logicViewModel.index == 0) {
                    logicViewModel.index = logicViewModel.getContacts().size() - 1;
                } else {
                    logicViewModel.index--;
                }
                setContact(logicViewModel);
            }else {
                if (logicViewModel.index == 0) {
                    logicViewModel.index = (int) (logicViewModel.getContacts().stream().filter(Contact::getFavourite).count() - 1);
                } else {
                    logicViewModel.index--;
                }
                setFavourtie(logicViewModel);
            }
        });

        binding.btRight.setOnClickListener(view -> {
            if (!logicViewModel.favourites) {
                if (logicViewModel.index == logicViewModel.getContacts().size() - 1) {
                    logicViewModel.index = 0;
                } else {
                    logicViewModel.index++;
                }
                setContact(logicViewModel);
            }else {
                if (logicViewModel.index == (int) logicViewModel.getContacts()
                        .stream().filter(Contact::getFavourite).count() - 1) {
                    logicViewModel.index = 0;
                } else {
                    logicViewModel.index++;
                }
                setFavourtie(logicViewModel);
            }
        });

        binding.ivCall.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + logicViewModel.getContacts().get(logicViewModel.index).getNumber()));
            startActivity(intent);
        });

        binding.ivFavourite.setOnClickListener(view -> {
            if (logicViewModel.getContacts().get(logicViewModel.index).getFavourite()) {
                logicViewModel.getContacts().get(logicViewModel.index).setFavourite(false);
                binding.ivFavourite.setImageResource(R.drawable.star);
            }else {
                logicViewModel.getContacts().get(logicViewModel.index).setFavourite(true);
                binding.ivFavourite.setImageResource(R.drawable.yellow_star);
            }
        });

        binding.btBack.setOnClickListener(view -> {
            logicViewModel.safeList(getContext().getApplicationContext());
            mainViewModel.showFirstPage();
        });

        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    public void setFavourtie(LogicViewModel logicViewModel){
        binding.tvName.setText(logicViewModel.getContacts().stream().filter(Contact::getFavourite).collect(Collectors.toList())
                .get(logicViewModel.index).getFirstname() + " " + logicViewModel.getContacts()
                .get(logicViewModel.index).getLastname());
        binding.tvNumber.setText(logicViewModel.getContacts().stream().filter(Contact::getFavourite).collect(Collectors.toList())
                .get(logicViewModel.index).getNumber() + "");
        binding.tvIndex.setText(logicViewModel.index+1 + " / " + (int) logicViewModel.getContacts()
                .stream().filter(Contact::getFavourite).count());
        binding.ivFavourite.setImageResource(R.drawable.yellow_star);
    }

    @SuppressLint("SetTextI18n")
    public void setContact(LogicViewModel logicViewModel){
        binding.tvName.setText(logicViewModel.getContacts().get(logicViewModel.index).getFirstname() + " " + logicViewModel.getContacts().get(logicViewModel.index).getLastname());
        binding.tvNumber.setText(logicViewModel.getContacts().get(logicViewModel.index).getNumber() + "");
        binding.tvIndex.setText(logicViewModel.index + 1 + " / " + logicViewModel.getContacts().size());
        if (logicViewModel.getContacts().get(logicViewModel.index).getFavourite()){
            binding.ivFavourite.setImageResource(R.drawable.yellow_star);
        }else {
            binding.ivFavourite.setImageResource(R.drawable.star);
        }
    }
}