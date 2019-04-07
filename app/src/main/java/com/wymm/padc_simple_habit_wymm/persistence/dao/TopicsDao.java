package com.wymm.padc_simple_habit_wymm.persistence.dao;

import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by Wai Yan Myint Myat on 4/7/19.
 */
@Dao
public interface TopicsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertTopicsList(List<TopicsVO> topicsVOList);

    @Query("SELECT * FROM topics")
    List<TopicsVO> selectTopicsList();
}
