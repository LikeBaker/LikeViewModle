package com.like.likeviewmodle.room;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/**
 * Created by liuzhen on 2020/9/21.
 */

public class DbHelper extends AppDatabase {

    private static AppDatabase mAppDatabase;

    public static synchronized AppDatabase getInstance(Context context){
        if (mAppDatabase == null) {
            mAppDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "jwth_bracelet").build();
        }

        return mAppDatabase;
    }

    @Override
    public BraceletDao braceletDao() {
        return null;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        Log.d("DbHelper", "createOpenHelper");
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        Log.d("DbHelper", "createInvalidationTracker");
        return null;
    }

    @Override
    public void clearAllTables() {
        Log.d("DbHelper", "clearAllTables");
    }
}
