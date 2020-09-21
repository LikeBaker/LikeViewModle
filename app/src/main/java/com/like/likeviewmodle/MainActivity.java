package com.like.likeviewmodle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BraceletDataModule mViewModel;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.tv_content);

//        mViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(BraceletDataModule.class);
         mViewModel = ViewModelProviders.of(this).get(BraceletDataModule.class);


        mViewModel.getBraceletLiveData().observe(this, new Observer<BraceletData>() {
            @Override
            public void onChanged(BraceletData braceletData) {
                String step = braceletData.getStep();
                if (step != null) {
                    content.setText(step);
                }
            }
        });


    }

    public void upDateData(View view) {
        //更新数据
        mViewModel.doAction();
    }
}