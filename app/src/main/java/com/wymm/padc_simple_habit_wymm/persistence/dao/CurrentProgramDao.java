package com.wymm.padc_simple_habit_wymm.persistence.dao;

import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by Wai Yan Myint Myat on 4/6/19.
 */
@Dao
public interface CurrentProgramDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertCurrentProgram(CurrentProgramVO currentProgramVO);

    @Query("SELECT * FROM current_program")
    CurrentProgramVO getCurrentProgram();
}
