package com.dg.livedataexample.activities;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dg.livedataexample.R;
import com.dg.livedataexample.fragments.ShowDataFragment;
import com.dg.livedataexample.models.NameModel;
import com.dg.livedataexample.utils.Logs;
import com.dg.livedataexample.view_models.NameViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pos)
    EditText et_pos;
    @BindView(R.id.tv_show)
    TextView tv_show;
    @BindView(R.id.bt_Add)
    Button bt_Add;


    public NameViewModel nameViewModel;
    public List<NameModel> listNameModel;
    NameModel nameModel;


    private FragmentTransaction transaction;

    public NameViewModel getNameViewModel() {
        return nameViewModel;
    }


    public List<NameModel> getListNameModel() {
        return listNameModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_layout, new ShowDataFragment()).commit();


        nameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        listNameModel = new ArrayList<>();


        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nameModel = new NameModel(new Random().nextInt(), etName.getText().toString());


                if (listNameModel.size() > 0) {
                    if (et_pos.getText().toString().length() > 0 && Integer.parseInt(et_pos.getText().toString()) < listNameModel.size()) {
                        listNameModel.set(Integer.parseInt(et_pos.getText().toString()), nameModel);
                    } else {
                        listNameModel.set(listNameModel.size() - 1, nameModel);
                    }
                } else {
                    listNameModel.add(nameModel);
                }

                nameViewModel.getMutableLiveData().setValue(listNameModel);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        bt_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameModel = new NameModel(new Random().nextInt(), etName.getText().toString());
                listNameModel.add(nameModel);
                nameViewModel.getMutableLiveData().setValue(listNameModel);
            }
        });
    }
}
