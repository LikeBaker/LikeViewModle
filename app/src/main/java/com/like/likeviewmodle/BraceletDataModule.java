package com.like.likeviewmodle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by liuzhen on 2020/9/11.
 */

class BraceletDataModule extends ViewModel {
    MutableLiveData<BraceletData> braceletLiveData = new MutableLiveData<>();


    public MutableLiveData<BraceletData> getBraceletLiveData() {
        return braceletLiveData;
    }

    public void doAction() {
        BraceletData value = braceletLiveData.getValue();
        value.setStep("10000");
    }
}
