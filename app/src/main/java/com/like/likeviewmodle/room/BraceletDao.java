package com.like.likeviewmodle.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Created by liuzhen on 2020/9/21.
 */
@Dao
public interface BraceletDao {
    @Query("SELECT * FROM BraceletLocalData")
    List<BraceletLocalData> getAll();

    @Query("SELECT * FROM BraceletLocalData WHERE uid IN (:userIds)")
    List<BraceletLocalData> loadAllByIds(int[] userIds);

    // TODO: 2020/9/21  ???
    @Query("SELECT * FROM BraceletLocalData WHERE bracelet_step LIKE :bracelet_step AND " +
            "temperature LIKE :temperature LIMIT 1")
    BraceletLocalData findByName(String bracelet_step, String temperature);

    @Insert
    void insertAll(BraceletLocalData... braceletLocalData);

    @Delete
    void delete(BraceletLocalData user);
}

