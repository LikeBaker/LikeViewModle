package com.like.likeviewmodle;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by liuzhen on 2020/9/11.
 */

public class BraceletDataModule extends ViewModel {

    private MutableLiveData<BraceletData> braceletLiveData = new MutableLiveData<>();

    public MutableLiveData<BraceletData> getBraceletLiveData() {
        return braceletLiveData;
    }

    public BraceletDataModule() {
//        braceletLiveData.postValue(new BraceletData("0", "0"));
    }

    void doAction() {
        Log.d("BraceletDataModule", "do action");
        BraceletData value = getBraceletLiveData().getValue();
        if (value != null) {
            Log.d("BraceletDataModule", value.getStep());
            Log.d("BraceletDataModule", value.getTemp());
            value.setStep("1000");
            Log.d("BraceletDataModule", value.getStep());
            braceletLiveData.setValue(value);//必须调用setValue才能触发observer
        } else {
            Log.d("BraceletDataModule", "value is null");
        }
    }

}
