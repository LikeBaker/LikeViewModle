package com.like.likeviewmodle;

import android.content.Context;
import android.util.Log;

import com.like.likeviewmodle.room.AppDatabase;
import com.like.likeviewmodle.room.BraceletDao;
import com.like.likeviewmodle.room.BraceletLocalData;
import com.like.likeviewmodle.room.DbHelper;

import java.util.List;

/**
 * Created by liuzhen on 2020/9/21.
 */

class BraceletDataResponse {

    private Context mContext;
    private DbHelper dbHelper;
    private final BraceletDao braceletDao;

    public BraceletDataResponse(Context context) {
        this.mContext = context;

        AppDatabase appDatabase = DbHelper.getInstance(context);
        braceletDao = appDatabase.braceletDao();
        List<BraceletLocalData> all = braceletDao.getAll();
        Log.d("BraceletDataResponse", "all:" + all);
    }

    public boolean setBraceletData(BraceletLocalData braceletLocalData){
        return false;
    }

    // TODO: 2020/9/21 可能存储了不同用户的数据
    public List<BraceletLocalData> getBraceletData(){
        return braceletDao.getAll();
    }
}
