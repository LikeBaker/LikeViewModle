package com.like.likeviewmodle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.like.likeviewmodle.room.BraceletLocalData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BraceletDataModule mViewModel;
    private TextView content;
    private BraceletData mBraceletData;
    private BraceletDataResponse braceletDataResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.tv_content);



//        mViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(BraceletDataModule.class);
//        mViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(BraceletDataModule.class);
//        mViewModel = new BraceletDataModule();
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory(getApplication());
        /**
         * create方法报错
         * InstantiationException 需要默认构造方法
         * java.lang.IllegalAccessException: java.lang.Class<com.like.likeviewmodle.BraceletDataModule> is not accessible from java.lang.Class<androidx.lifecycle.ViewModelProvider$NewInstanceFactory>
         * ViewModel需要加public
         */
        mViewModel = androidViewModelFactory.create(BraceletDataModule.class);
        MutableLiveData<BraceletData> braceletLiveData = mViewModel.getBraceletLiveData();

        BraceletData value = braceletLiveData.getValue();
        if (value != null) {
            Log.d("MainActivity", value.getStep());
        } else {
            Log.d("MainActivity", "没有历史记录");
        }

        mBraceletData = new BraceletData("1", "2");
        braceletLiveData.setValue(mBraceletData);//这里初始化了，observe中的数据才有值

//        Log.d("MainActivity", "getLifecycle().getCurrentState():" + getLifecycle().getCurrentState());
//        getLifecycle().addObserver(new LifecycleEventObserver() {
//            @Override
//            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
//                Log.d("MainActivity", "onStateChanged");
//                Log.d("MainActivity", source.toString());
//                Log.d("MainActivity", event.toString());
//            }
//        });


        mViewModel.getBraceletLiveData().observe(this, new Observer<BraceletData>() {
            @Override
            public void onChanged(BraceletData braceletData) {
                Log.d("MainActivity", "onChanged");
                String step = braceletData.getStep();
                Log.d("MainActivity", step);
                content.setText(step);

            }
        });


        braceletDataResponse = new BraceletDataResponse(this);
        braceletDataResponse.setBraceletData(new BraceletLocalData(1, "1", "2"));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "getLifecycle().getCurrentState():" + getLifecycle().getCurrentState());

    }

    public void upDateData(View view) {
        //更新数据
//        mViewModel.getBraceletLiveData().setValue(new BraceletData("3", "4"));//重新给livedata赋值会触发observer
        mBraceletData.setStep("3");
        mBraceletData.setTemp("4");
        mViewModel.doAction();

        new Thread(){
            @Override
            public void run() {
                super.run();
                List<BraceletLocalData> braceletData = braceletDataResponse.getBraceletData();
                Log.d("MainActivity", "braceletData:" + braceletData);
            }
        }.start();

    }
}