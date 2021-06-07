package com.example.talent_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TalentFragment extends Fragment {
    RecyclerView talentrecyclerView;
    TalentAdapter talentAdapter;
    TalentViewModel talentViewModel;

    public TalentFragment() {
        // Required empty public constructor
    }


    public static TalentFragment newInstance(String param1, String param2) {
        TalentFragment fragment = new TalentFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_talent, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        talentViewModel = ViewModelProviders.of(this).get(TalentViewModel.class);
        talentrecyclerView = getView().findViewById(R.id.talent_recycleView);
        talentAdapter = new TalentAdapter();
        talentrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        talentrecyclerView.setAdapter(talentAdapter);

        talentViewModel.getAllTalentEntityLive().observe(getActivity(), new Observer<List<TalentEntity>>() {
            @Override
            public void onChanged(List<TalentEntity> talentEntities) {
                talentAdapter.setAllTalentEntity(talentEntities);
                talentAdapter.notifyDataSetChanged();
            }
        });
    }
}