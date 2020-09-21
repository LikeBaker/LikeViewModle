package com.like.likeviewmodle.room;

import java.util.List;

/**
 * Created by liuzhen on 2020/9/21.
 */

class BraceletLocalDataDao implements BraceletDao {
    @Override
    public List<BraceletLocalData> getAll() {
        return null;
    }

    @Override
    public List<BraceletLocalData> loadAllByIds(int[] userIds) {
        return null;
    }

    @Override
    public BraceletLocalData findByName(String bracelet_step, String temperature) {
        return null;
    }

    @Override
    public void insertAll(BraceletLocalData... users) {

    }

    @Override
    public void delete(BraceletLocalData user) {

    }
}
