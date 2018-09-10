package com.dg.livedataexample.view_models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.dg.livedataexample.models.NameModel;

import java.util.List;

/**
 * Created by Giang Long on 9/7/2018.
 * Skype: gianglong7695@gmail.com (id: gianglong7695_1)
 * Phone: 0979 579 283
 */
public class NameViewModel extends AndroidViewModel {
    private MutableLiveData<List<NameModel>> mutableLiveData;
    private NameModel nameModel;


    public NameViewModel(@NonNull Application application) {
        super(application);
        mutableLiveData = new MutableLiveData<>();
    }


    public MutableLiveData<List<NameModel>> getMutableLiveData() {
        return mutableLiveData;
    }
}
