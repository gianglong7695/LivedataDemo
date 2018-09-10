package com.dg.livedataexample.fragments;


import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dg.livedataexample.R;
import com.dg.livedataexample.activities.MainActivity;
import com.dg.livedataexample.adapters.ListNameAdapter;
import com.dg.livedataexample.models.NameModel;
import com.dg.livedataexample.utils.Logs;
import com.dg.livedataexample.view_models.NameViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowDataFragment extends Fragment implements LifecycleOwner {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rv_name)
    RecyclerView rv_name;


    ListNameAdapter adapter;
    List<NameModel> listNameModel;


    private NameViewModel nameViewModel;

    public ShowDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_show_data, container, false);
        ButterKnife.bind(this, v);


        nameViewModel = ((MainActivity) getActivity()).getNameViewModel();
        rv_name.setLayoutManager(new LinearLayoutManager(getActivity()));
        listNameModel = new ArrayList<>();


        adapter = new ListNameAdapter(getContext(), listNameModel);
        rv_name.setAdapter(adapter);


        nameViewModel.getMutableLiveData().observe(this, new Observer<List<NameModel>>() {
            @Override
            public void onChanged(@Nullable List<NameModel> listName) {
                tvName.setText(listName.get(listName.size() - 1).getName());
                adapter.setListName(((MainActivity) getActivity()).getListNameModel());
                Logs.e(listName.size() + " Size");
            }
        });


        return v;
    }

}
