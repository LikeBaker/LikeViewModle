package com.like.likeviewmodle.room;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/**
 * Created by liuzhen on 2020/9/21.
 */
@Database(entities = {BraceletLocalData.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BraceletDao braceletDao();
}
