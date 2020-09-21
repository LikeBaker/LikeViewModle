package com.like.likeviewmodle.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by liuzhen on 2020/9/21.
 */

@Entity
public class BraceletLocalData {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "bracelet_step")
    public String step;

    @ColumnInfo
    public String temperature;

    public BraceletLocalData(int uid, String step, String temperature) {
        this.uid = uid;
        this.step = step;
        this.temperature = temperature;
    }
}
